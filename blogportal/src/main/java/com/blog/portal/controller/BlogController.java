package com.blog.portal.controller;

import com.blog.pojo.TbBlogCustom;
import com.blog.portal.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/20.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/{id}")
    public String getBlogListById(@PathVariable Long id, Model model){
        List<TbBlogCustom> list=blogService.getBlogListById(id);
        System.out.println(id);
        model.addAttribute("blog",list);
        return "info";
    }

}
