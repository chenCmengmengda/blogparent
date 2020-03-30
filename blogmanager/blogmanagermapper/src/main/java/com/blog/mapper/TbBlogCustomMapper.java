package com.blog.mapper;

import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogCustom;

import java.util.Date;
import java.util.List;


/**
 * Created by 陈_C on 2018/8/20.
 */
public interface TbBlogCustomMapper {
    TbBlogCustom getBlogListById(Long id);
    List<TbBlog> getNewBlogTitle();
    List<TbBlog> getBlogListByCatId(Long catId);
    TbBlog getPreBlogByTime(Date createTime);
    TbBlog getNextBlogByTime(Date createTime);
}
