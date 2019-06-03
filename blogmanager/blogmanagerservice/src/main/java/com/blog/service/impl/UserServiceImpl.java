package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbPermissionMapperCustom;
import com.blog.mapper.TbUserMapperCustom;
import com.blog.mapper.TbUserMapper;
import com.blog.mapper.TbUserRoleMapper;
import com.blog.pojo.*;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理Service层
 * Created by 陈_C on 2018/7/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    TbUserMapper userMapper;
    @Autowired
    TbUserMapperCustom userMapperCustom;
    @Autowired
    TbUserRoleMapper userRoleMapper;
    @Autowired
    TbPermissionMapperCustom permissionMapperCustom;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Result addUser(TbUser user){
        Long userId= IDUtils.genItemId();
        user.setId(userId);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
        return Result.ok();
    }

    /**
     * 查询用户列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EUDataGridResult userList(int page, int rows){
        TbUserExample example=new TbUserExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbUser> list=userMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbUser> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public Result updateUser(TbUser user){

        userMapper.updateByPrimaryKey(user);
        return Result.ok();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public Result deleteUser(Long id){
        userMapper.deleteByPrimaryKey(id);
        return Result.ok();
    }

    @Override
    public Result userLogin(String nickname, String password, HttpServletRequest request,
                        HttpServletResponse response){
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo(nickname);
        List<TbUser> list = userMapper.selectByExample(example);
        //如果没有此用户名
        if (null == list || list.size() == 0) {
            return Result.build(400, "用户名或密码错误");
        }
        TbUser user = list.get(0);
        //比对密码
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return Result.build(400, "用户名或密码错误");
        }
        HttpSession session=request.getSession();
        session.setAttribute("username",nickname);
     //   CookieUtils.setCookie(request,response,"username",nickname);
        //返回token
        return Result.build(200,"/");
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    public Result editPassword(TbUser user,String rePassword){
        //两次密码不正确
        if(!user.getPassword().equals(rePassword)){
            return new Result(400,"ok",null);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapperCustom.editPassword(user);
        return Result.ok();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser user = null;
        TbUserCustom userCustom=null;
        try {
            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria criteria = example.createCriteria();
            criteria.andNicknameEqualTo(username);
            user = userMapper.selectByExample(example).get(0);
            userCustom=userMapperCustom.findUserRolePermissionById(user.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User u = new User(user.getNickname(), user.getPassword(), true, true, true, true, getAuthority(userCustom.getRoleCustomList()));
        return u;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<TbRoleCustom> roleList) {



        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(TbRoleCustom roleCustom:roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + roleCustom.getRolename()));
        }
        return list;
    }

    @Override
    public Result findOne(Long id){
        TbUser user=userMapper.selectByPrimaryKey(id);
        return Result.ok(user);
    }

    @Override
    public EUDataGridResult findOtherRoles(Long id){
        List<TbRole> list=userMapperCustom.findOtherRoles(id);
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        return result;
    }

    @Override
    public Result addRoleToUser(Long userId, Long[] roleIds){
        for(Long roleId:roleIds) {
            userMapperCustom.addRoleToUser(userId, roleId);
        }
        return Result.ok();
    }

    @Override
    public TbUserCustom findUserRolePermissionById(Long userId){
        TbUserCustom userCustom=userMapperCustom.findUserRolePermissionById(userId);
        return userCustom;
    }

    @Override
    public Result deleteRoleToUser(TbUserRoleKey userRoleKey){
       userRoleMapper.deleteByPrimaryKey(userRoleKey);
        return Result.ok();
    }

}
