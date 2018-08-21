package com.blog.rest.service;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbBlogCustom;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/19.
 */
public interface BlogService {
    ListDataResult getBlogList(Integer page, Integer rows);
    List<TbBlogCustom> getBlogListById(Long id);
}
