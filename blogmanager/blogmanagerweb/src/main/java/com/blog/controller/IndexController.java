package com.blog.controller;

import com.blog.common.pojo.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈_C on 2018/7/25.
 */
@Controller
public class IndexController {

    /*
    @RequestMapping("/")
    public String index(Model model){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("username",username);
        return "index";
    }
*/
    @RequestMapping("/index.do")
    @ResponseBody
    public Result indexdo(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,String> map=new HashMap<>();
        map.put("username",username);

        return Result.ok(map);
    }

    @RequestMapping("/loginSuccess.do")
    @ResponseBody
    public Result loginSuccess(){
        return Result.build(200,"/admin/index.html");
    }

    @RequestMapping("/loginFailer.do")
    @ResponseBody
    public Result loginFailer(){
        return Result.build(400,"用户名或密码错误");
    }

    @RequestMapping("/403.do")
    @ResponseBody
    public Result access(){
        return Result.build(403,"/403.html");
    }

    /**
     * 展示其他页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page) {

        return page;
    }
}
