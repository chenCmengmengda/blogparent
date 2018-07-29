package com.blog.service;

import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;

/**
 * 用户管理service层
 * Created by 陈_C on 2018/7/29.
 */
public interface UserService {
    Result addUser(TbUser user);
}