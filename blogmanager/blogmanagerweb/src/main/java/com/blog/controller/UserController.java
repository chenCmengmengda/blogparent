package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbUser;
import com.blog.pojo.TbUserCustom;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
@Secured("ROLE_ADMIN")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public Result userAdd(@RequestBody TbUser user){
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
    @RequestMapping("/list.do")
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
/*
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
*/
/*
    @RequestMapping("/editpassword")
    @ResponseBody
    public Result editPassword(TbUser user,String repassword){
        Result result=userService.editPassword(user,repassword);
        System.out.println(user.getPassword());
        System.out.println(repassword);
        return result;
    }
    */

    @RequestMapping("/editpassword.do")
    @ResponseBody
    public Result editPassword(@RequestBody TbUserObj userObj){

        Result result=userService.editPassword(userObj.getUser(),userObj.getRepassword());

        return Result.ok();
    }

    /**
     *
     * @param id userId
     * @return
     */
    @RequestMapping("/findOne.do")
    @ResponseBody
    public Result findOne(Long id){
        Result result=userService.findOne(id);
        return result;
    }

    @RequestMapping("/findOtherRoles.do")
    @ResponseBody
    public EUDataGridResult findOtherRoles(Long id){
        EUDataGridResult result=userService.findOtherRoles(id);
        return result;
    }

    @RequestMapping("addRoleToUser.do")
    @ResponseBody
    public Result addRoleToUser(Long userId, Long[] roleIds){
        Result result=userService.addRoleToUser(userId,roleIds);
        return result;
    }

    @RequestMapping("/findUserRolePermissionById.do")
    @ResponseBody
    public TbUserCustom findUserRolePermissionById(Long userId){
        TbUserCustom userCustom=userService.findUserRolePermissionById(userId);
        return userCustom;
    }
}

class TbUserObj{
    TbUser user;
    String repassword;

    public TbUser getUser() {
        return user;
    }

    public void setUser(TbUser user) {
        this.user = user;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
