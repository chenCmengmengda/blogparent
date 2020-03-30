package com.blog.rest.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.mapper.TbBlogCatCustomMapper;
import com.blog.mapper.TbBlogMapper;
import com.blog.pojo.*;
import com.blog.mapper.TbBlogCustomMapper;
import com.blog.rest.dao.JedisClient;
import com.blog.rest.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
    @Autowired
    private TbBlogCatCustomMapper blogCatCustomMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_BLOG_LIKE_KEY}")
    private String REDIS_BLOG_LIKE_KEY;

    /**
     * 获取博客列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public ListDataResult getBlogList(Integer page, Integer rows){
        //查询博客列表
        TbBlogExample example=new TbBlogExample();
        //根据时间查询
        example.setOrderByClause("create_time DESC");
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbBlogWithBLOBs> list=blogMapper.selectByExampleWithBLOBs(example);

        ListDataResult result=new ListDataResult();
        result.setPage(page);
        result.setRows(list);
        //取总博客数
        PageInfo<TbBlogWithBLOBs> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        System.out.println(pageInfo.getTotal()+":"+pageInfo.getPages());
        return result;
    }

    @Override
    public Result getBlogListById(Long id){
        TbBlogCustom blogCustom=blogCustomMapper.getBlogListById(id);
    //    TbBlogWithBLOBs blog=blogMapper.selectByPrimaryKey(id);
        return Result.ok(blogCustom);
    }

    /**
     * 设置点赞
     * @param blogId
     * @return
     */
    @Override
    public Result setBlogLike(Long blogId) {
        jedisClient.incr(REDIS_BLOG_LIKE_KEY+":"+blogId);

        return Result.ok();
    }

    /**
     * 获取点赞
     * @param blogId
     * @return
     */
    @Override
    public Result getBlogLike(Long blogId) {
        String blogLike=jedisClient.get(REDIS_BLOG_LIKE_KEY+":"+blogId);
        if(blogLike==null){
            jedisClient.set(REDIS_BLOG_LIKE_KEY+":"+blogId,"0");
            blogLike="0";
        }
        return Result.ok(blogLike);
    }

    @Override
    public Result getBlogCatCount(){
        List<TbBlogCatCustom> list=blogCatCustomMapper.getBlogCatCount();
        return Result.ok(list);
    }

    @Override
    public ListDataResult getBlogListByCatId(Long catId, Integer page, Integer rows){
        TbBlogExample example=new TbBlogExample();
        example.setOrderByClause("create_time DESC");
        example.createCriteria().andBlogCatIdEqualTo(catId);
        PageHelper.startPage(page,rows);
        List<TbBlogWithBLOBs> list=blogMapper.selectByExampleWithBLOBs(example);
        //根据日期排序
        /*
        Collections.sort(list,new Comparator<TbBlog>(){
            @Override
            public int compare(TbBlog o1, TbBlog o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                Date dt1 = o1.getCreateTime();
                Date dt2 = o2.getCreateTime();
                if (dt1.getTime() < dt2.getTime()) {
                    return 1;
                } else if (dt1.getTime() > dt2.getTime()) {
                    return -1;
                } else {
                    return 0;
                }


            }
        });
        */
        ListDataResult result=new ListDataResult();
        result.setPage(page);
        result.setRows(list);
        //取总博客数
        PageInfo<TbBlogWithBLOBs> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());

        return result;

    }

    /**
     * 查询最新文章
     * @param rows
     * @return
     */
    @Override
    public Result getNewBlogTitle(Integer rows){
        PageHelper.startPage(1,rows);
        List<TbBlog> list=blogCustomMapper.getNewBlogTitle();
        return Result.ok(list);

    }
}
