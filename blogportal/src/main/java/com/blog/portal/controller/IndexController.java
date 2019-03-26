package com.blog.portal.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.pojo.TbBlog;
import com.blog.portal.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 主页显示
 * Created by 陈_C on 2018/8/18.
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/index")
    public String showIndex(@RequestParam(defaultValue = "1") Integer page ,
                            @RequestParam(defaultValue = "10") Integer rows,Model model){
    //    ListDataResult result=blogService.getBlogList(page,rows);
    //    model.addAttribute("blogListResult",result);
    //    model.addAttribute("page",page);
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){

        return page;
    }
}
