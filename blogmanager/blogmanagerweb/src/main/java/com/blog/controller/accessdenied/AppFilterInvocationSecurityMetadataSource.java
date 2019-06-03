package com.blog.controller.accessdenied;

import com.blog.mapper.*;
import com.blog.pojo.TbPermission;
import com.blog.pojo.TbPermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource  {

    private FilterInvocationSecurityMetadataSource superMetadataSource;
    private HashMap<String, Collection<ConfigAttribute>> map =null;

    @Autowired
    TbRoleMapperCustom roleMapperCustom;
    @Autowired
    TbPermissionMapper permissionMapper;
    @Autowired
    TbUserMapperCustom userMapperCustom;

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(map ==null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;

    }

    /**
     * 判断当前请求是否在允许请求的范围内
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi){
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    /**
     * 参考：
     * https://blog.csdn.net/pujiaolin/article/details/73928491
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest() {
        return Arrays.asList("/login", "/css/**", "/fonts/**", "/js/**", "/scss/**", "/img/**");
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public AppFilterInvocationSecurityMetadataSource(FilterInvocationSecurityMetadataSource expressionBasedFilterInvocationSecurityMetadataSource){
        this.superMetadataSource = expressionBasedFilterInvocationSecurityMetadataSource;

        // TODO 从数据库加载权限配置
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 自定义方法。最好在项目启动时，去数据库查询一次就好。
     * 数据库查询一次 权限表出现的所有要拦截的url
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        //去数据库查询 使用dao层。 你使用自己的即可

        TbPermissionExample example=new TbPermissionExample();
        List<TbPermission> permissions = permissionMapper.selectByExample(example);
        for(TbPermission permission : permissions) {
            array = new ArrayList<>();
            //下面你可以添加你想要比较的信息过去。 注意的是，需要在用户登录时存储的权限信息一致
            cfg = new SecurityConfig(permission.getPermissionname());
            //此处添加了资源菜单的名字，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。

            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getUrl(), array);
        }

    }

}
