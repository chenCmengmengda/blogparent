package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户管理service层
 * Created by 陈_C on 2018/7/29.
 */
public interface UserService {
    Result addUser(TbUser user);
    EUDataGridResult userList(int page, int rows);
    Result updateUser(TbUser user);
    Result deleteUser(Long id);
    Result userLogin(String username , String password, HttpServletRequest request,
                        HttpServletResponse response);
}
