package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlog;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 博客系统
 * Created by 陈_C on 2018/8/7.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/add")
    @ResponseBody
    public Result createBlog(TbBlog blog,String desc) throws Exception{
        Result result=blogService.createBlog(blog,desc);
        return result;
    }

    /**
     * 博客列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getUserList(Integer page, Integer rows){
        EUDataGridResult result=blogService.blogList(page,rows);

        return result;
    }

    @RequestMapping("/read")
    @ResponseBody
    public Result readBlog(Long id){
        Result result=blogService.readBlog(id);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Result editBlog(TbBlog blog,String desc) throws Exception{
        Result result=blogService.editBlog(blog,desc);
        return result;
    }
}
