package com.blog.controller;

import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 陈_C on 2018/7/29.
 */
@Controller
@RequestMapping("/user")
public class UserComtroller {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public Result userList(){

        return Result.ok();
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result userAdd(TbUser user){
        System.out.println(user.getNickname()+":"+user.getBirthday());
        Result result=userService.addUser(user);
        return result;
    }
}
