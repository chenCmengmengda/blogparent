package com.blog.mapper;

import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogCustom;

import java.util.List;


/**
 * Created by 陈_C on 2018/8/20.
 */
public interface TbBlogCustomMapper {
    List<TbBlogCustom> getBlogListById(Long id);
    List<TbBlog> getNewBlogTitle();
    List<TbBlog> getBlogListByCatId(Long catId);
}
