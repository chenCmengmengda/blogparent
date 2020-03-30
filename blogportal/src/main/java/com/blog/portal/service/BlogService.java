package com.blog.portal.service;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogCustom;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/19.
 */
public interface BlogService {
    ListDataResult getBlogList(Integer page, Integer rows);
    Result getBlogListById(Long id);
    Result setBlogLike(Long blogId);
    Result getBlogLike(Long blogId);
    Result getBlogCatCount();
    ListDataResult getBlogListByCatId(Long catId,Integer page,Integer rows);
    Result getNewBlogTitle(Integer rows);
}
