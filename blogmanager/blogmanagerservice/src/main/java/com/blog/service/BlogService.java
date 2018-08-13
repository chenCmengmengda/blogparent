package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogDesc;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/7.
 */
public interface BlogService {
    Result createBlog(TbBlog blog,String desc) throws Exception;
    EUDataGridResult blogList(int page,int rows);
    Result readBlog(Long id);
    Result editBlog(TbBlog blog, String desc) throws Exception;

}
