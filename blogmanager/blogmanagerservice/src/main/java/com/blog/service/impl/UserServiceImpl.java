package com.blog.service.impl;

import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbUserMapper;
import com.blog.pojo.TbUser;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理Service层
 * Created by 陈_C on 2018/7/29.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    TbUserMapper userMapper;

    @Override
    public Result addUser(TbUser user){
        Long userId= IDUtils.genItemId();
        user.setId(userId);
        userMapper.insert(user);
        return Result.ok();
    }
}
