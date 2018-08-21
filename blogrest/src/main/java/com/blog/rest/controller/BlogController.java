package com.blog.rest.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlogCustom;
import com.blog.rest.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/19.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/info")
    @ResponseBody
    public ListDataResult getBlogList(Integer page , Integer rows) {
        ListDataResult result=blogService.getBlogList(page,rows);
        return result;
    }

    @RequestMapping("/content/{id}")
    @ResponseBody
    public List<TbBlogCustom> getBlogList(@PathVariable Long id) {
        System.out.println(id);
        List<TbBlogCustom> list=blogService.getBlogListById(id);
        return list;
    }

}
