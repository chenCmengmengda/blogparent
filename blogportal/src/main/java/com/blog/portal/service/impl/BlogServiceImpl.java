package com.blog.portal.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.HttpClientUtil;
import com.blog.common.util.JsonUtils;
import com.blog.pojo.TbBlogCustom;
import com.blog.portal.service.BlogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 博客展示服务层
 * Created by 陈_C on 2018/8/19.
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${BLOG_INFO_URL}")
    private String BLOG_INFO_URL;
    @Value("${BLOG_DESC_URL}")
    private String BLOG_DESC_URL;
    @Value("${BLOG_ADD_LIKE_URL}")
    private  String BLOG_ADD_LIKE_URL;
    @Value("${BLOG_GET_LIKE_URL}")
    private  String BLOG_GET_LIKE_URL;

    /**
     * 获得博客列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public ListDataResult getBlogList(Integer page, Integer rows){
        String json= HttpClientUtil.doGet(REST_BASE_URL+BLOG_INFO_URL+"?page="+page+"&rows="+rows);
        ListDataResult result= JsonUtils.jsonToPojo(json,ListDataResult.class);
        return result;
    }

    @Override
    public Result getBlogListById(Long id){
        String json= HttpClientUtil.doGet(REST_BASE_URL+BLOG_DESC_URL+id);
        System.out.println(json);
        Result result= JsonUtils.jsonToPojo(json,Result.class);
        return result;
    }

    @Override
    public Result setBlogLike(Long blogId) {
        String json= HttpClientUtil.doGet(REST_BASE_URL+BLOG_ADD_LIKE_URL+"?id="+blogId);
        Result result=JsonUtils.jsonToPojo(json,Result.class);
        return result;
    }

    @Override
    public Result getBlogLike(Long blogId) {
        String json= HttpClientUtil.doGet(REST_BASE_URL+BLOG_GET_LIKE_URL+"?id="+blogId);
        System.out.println(json);
        Result result=JsonUtils.jsonToPojo(json,Result.class);
        return result;
    }

    @Override
    public Result getBlogCatCount(){
        String json= HttpClientUtil.doGet(REST_BASE_URL+"/blog/getBlogCatCount");
        System.out.println(json);
        Result result=JsonUtils.jsonToPojo(json,Result.class);
        return result;
    }

    @Override
    public ListDataResult getBlogListByCatId(Long catId,Integer page,Integer rows){
        String json= HttpClientUtil.doGet(REST_BASE_URL+"/blog/getBlogListByCatId"+"?catId="+catId+"&page="+page+"&rows="+rows);
        ListDataResult result= JsonUtils.jsonToPojo(json,ListDataResult.class);
        return result;
    }
}
