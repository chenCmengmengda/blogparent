package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;
import com.blog.pojo.TbUserCustom;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户管理service层
 * Created by 陈_C on 2018/7/29.
 */
public interface UserService  extends UserDetailsService {
    Result addUser(TbUser user);
    EUDataGridResult userList(int page, int rows);
    Result updateUser(TbUser user);
    Result deleteUser(Long id);
    Result userLogin(String username , String password, HttpServletRequest request,
                        HttpServletResponse response);
    Result editPassword(TbUser user,String rePassword);
    UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException;
    Result findOne(Long id);
    EUDataGridResult findOtherRoles(Long id);
    Result addRoleToUser(Long userId, Long[] roleIds);
    TbUserCustom findUserRolePermissionById(Long userId);
}
