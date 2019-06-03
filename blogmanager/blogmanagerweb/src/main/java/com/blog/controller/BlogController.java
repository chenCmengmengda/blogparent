package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogCat;
import com.blog.pojo.TbBlogCustom;
import com.blog.pojo.TbBlogWithBLOBs;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
/*
    @RequestMapping("/add.do")
    @ResponseBody
    public Result createBlog(@RequestBody TbBlog blog, String desc) throws Exception{
   //     Result result=blogService.createBlog(blog,desc);
        return Result.ok();
    }
*/
    @RequestMapping("/add.do")
    @ResponseBody
    public Result createBlog(@RequestBody TbBlogWithBLOBs blog) throws Exception{


        Result result=blogService.createBlog(blog);

        return result;
    }

    /**
     * 博客列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public EUDataGridResult getBlogList(Integer page, Integer rows){
        EUDataGridResult result=blogService.blogList(page,rows);

        return result;
    }

    @RequestMapping("/read")
    @ResponseBody
    public Result readBlog(Long id){
        Result result=blogService.readBlog(id);
        return result;
    }
/*
    @RequestMapping("/edit")
    @ResponseBody
    public Result editBlog(TbBlog blog,String desc) throws Exception{
        Result result=blogService.editBlog(blog,desc);
        return result;
    }
*/
    @RequestMapping("/edit.do")
    @ResponseBody
    public Result editBlog(@RequestBody TbBlogWithBLOBs blog) throws Exception{

        
        Result result=blogService.editBlog(blog);
        return result;
    }

    @RequestMapping("/findOne.do")
    @ResponseBody
    public Result findOne(Long id){

        return blogService.findOne(id);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public Result deleteBlog(Long[] ids){
        return blogService.deleteBlog(ids);
    }

    @RequestMapping("/getNewBlogTitle.do")
    @ResponseBody
    public Result getNewBlogTitle(Integer rows){
        return blogService.getNewBlogTitle(rows);
    }

    @RequestMapping("/getBlogCatList.do")
    @ResponseBody
    public EUDataGridResult blogCatList(Integer page, Integer rows) {
        return blogService.getBlogCatList(page,rows);
    }

    @RequestMapping("/addBlogCat.do")
    @ResponseBody
    public Result addBlogCat(@RequestBody TbBlogCat blogCat){
        return blogService.addBlogCat(blogCat);
    }

    @RequestMapping("/editBlogCat.do")
    @ResponseBody
    public Result editBlogCat(@RequestBody TbBlogCat blogCat){
        return blogService.editBlogCat(blogCat);
    }

    @RequestMapping("/deleteBlogCat.do")
    @ResponseBody
    public Result deleteBlogCat(Long[] ids){
        return blogService.deleteBlog(ids);
    }
}
