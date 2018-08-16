package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 陈_C on 2018/8/16.
 */
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("/login")
    public String showLogin(String redirect,Model model) {
        model.addAttribute("redirect",redirect);
        return "login";
    }
}
