package com.blog.search.service.impl;

import com.blog.common.pojo.Result;
import com.blog.common.util.ExceptionUtil;
import com.blog.search.mapper.BlogMapper;
import com.blog.search.pojo.Blog;
import com.blog.search.service.BlogService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private SolrServer solrServer;

    @Override
    public Result importAllBlog() {
        try {

            //查询商品列表
            List<Blog> list = blogMapper.getBlogList();
            //把商品信息写入索引库
            for (Blog blog : list) {
                //创建一个SolrInputDocument对象
                SolrInputDocument document = new SolrInputDocument();
                document.setField("id", blog.getId());
                document.setField("blog_title", blog.getTitle());
                document.setField("blog_image_url", blog.getImageUrl());
                document.setField("blog_summary", blog.getSummary());
                document.setField("blog_create_time", blog.getCreateTime());
                document.setField("blog_update_time", blog.getUpdateTime());
                document.setField("blog_desc", blog.getBlogDesc());
                //写入索引库
                solrServer.add(document);
            }
            //提交修改
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, ExceptionUtil.getStackTrace(e));
        }
        return Result.ok();
    }
}

