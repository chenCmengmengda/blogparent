package com.blog.portal.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlogCustom;
import com.blog.portal.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @ResponseBody
    public Result getBlogListById(@PathVariable Long id){
        Result result=blogService.getBlogListById(id);

        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ListDataResult getBlogList(@RequestParam(defaultValue = "1") Integer page ,
                                      @RequestParam(defaultValue = "10") Integer rows){
        ListDataResult result=blogService.getBlogList(page,rows);
        return result;

    }

    @RequestMapping("/addBlogLike")
    @ResponseBody
    public Result setBlogLike(Long id){
        Result result=blogService.setBlogLike((id));
        return result;
    }

    @RequestMapping("/getBlogLike")
    @ResponseBody
    public Result getBlogLike(Long id) {
        Result result=blogService.getBlogLike(id);
        return result;
    }

    @RequestMapping("/getBlogCatCount")
    @ResponseBody
    public Result getBlogCatCount(){
        Result result=blogService.getBlogCatCount();
        return result;
    }

    @RequestMapping("/getBlogListByCatId")
    @ResponseBody
    public ListDataResult getBlogListByCatId(Long catId, Integer page, Integer rows){
        return blogService.getBlogListByCatId(catId,page,rows);
    }

    @RequestMapping("/getNewBlogTitle")
    @ResponseBody
    public Result getNewBlogTitle(Integer rows){

        return blogService.getNewBlogTitle(rows);
    }

}
