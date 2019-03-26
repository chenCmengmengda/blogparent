package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.CookieUtils;
import com.blog.common.util.HttpClientUtil;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbUserCustomMapper;
import com.blog.mapper.TbUserMapper;
import com.blog.pojo.TbUser;
import com.blog.pojo.TbUserExample;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户管理Service层
 * Created by 陈_C on 2018/7/29.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    TbUserMapper userMapper;
    @Autowired
    TbUserCustomMapper userCustomMapper;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Result addUser(TbUser user){
        Long userId= IDUtils.genItemId();
        user.setId(userId);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
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
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userCustomMapper.editPassword(user);
        return Result.ok();
    }

}
