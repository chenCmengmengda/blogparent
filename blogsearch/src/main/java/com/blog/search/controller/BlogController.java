package com.blog.search.controller;

import com.blog.common.pojo.Result;
import com.blog.search.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 陈_C on 2018/7/18.
 */
@Controller
@RequestMapping("/manager")
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**
     * 导入商品数据到索引库
     */
    @RequestMapping("/importall")
    @ResponseBody
    public Result importAllItems() {
        Result result = blogService.importAllBlog();
        return result;
    }

}
