package com.blog.rest.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.mapper.TbBlogMapper;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogExample;
import com.blog.rest.mapper.TbBlogCustomMapper;
import com.blog.pojo.TbBlogCustom;
import com.blog.rest.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈_C on 2018/8/19.
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private TbBlogMapper blogMapper;
    @Autowired
    private TbBlogCustomMapper blogCustomMapper;

    @Override
    public ListDataResult getBlogList(Integer page, Integer rows){
        //查询博客列表
        TbBlogExample example=new TbBlogExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbBlog> list=blogMapper.selectByExampleWithBLOBs(example);
        ListDataResult result=new ListDataResult();
        result.setRows(list);
        //取总博客数
        PageInfo<TbBlog> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        System.out.println(pageInfo.getTotal()+":"+pageInfo.getPages());
        return result;
    }

    @Override
    public List<TbBlogCustom> getBlogListById(Long id){
        List<TbBlogCustom> list=blogCustomMapper.getBlogListById(id);
        return list;
    }
}
