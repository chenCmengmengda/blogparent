package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 陈_C on 2018/7/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result userAdd(TbUser user){
        System.out.println(user.getNickname()+":"+user.getBirthday());
        Result result=userService.addUser(user);
        return result;
    }

    /**
     * 用户列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getUserList(Integer page, Integer rows){
        EUDataGridResult result=userService.userList(page,rows);
        return result;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result updateUser(TbUser user){
        Result result = userService.updateUser(user);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteUser(Long ids){
        Result result=userService.deleteUser(ids);
        return result;
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Result userLogin(Model model, String username, String password, HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Result result = userService.userLogin(username, password,request,response);
        if(result.getStatus()!=400) {
            //储存用户名
        //    request.setAttribute("username",username);
            model.addAttribute("username",username);
        }
        return result;
    }

    @RequestMapping("/editpassword")
    @ResponseBody
    public Result editPassword(TbUser user,String repassword){
        Result result=userService.editPassword(user,repassword);
        System.out.println(user.getPassword());
        System.out.println(repassword);
        return result;
    }
}
