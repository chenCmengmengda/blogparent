package com.blog.search.dao.impl;


import com.blog.pojo.TbBlog;
import com.blog.search.dao.SearchDao;
import com.blog.search.pojo.Blog;
import com.blog.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 陈_C on 2018/7/18.
 */
@Repository
public class SearchDaoImpl implements SearchDao {
    @Autowired
    private SolrServer solrServer;

    @Override
    public SearchResult search(SolrQuery query) throws Exception {
        //返回值对象
        SearchResult result = new SearchResult();
        //根据查询条件查询索引库
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        //取查询结果总数量
        result.setRecordCount(solrDocumentList.getNumFound());
        //商品列表
        final List<Blog> blogList = new ArrayList<>();
        //取高亮显示
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        //取商品列表
        for (SolrDocument solrDocument : solrDocumentList) {
            //创建一商品对象
            Blog blog = new Blog();
            blog.setId(Long.parseLong((String)solrDocument.get("id")));

            blog.setTitle((String)solrDocument.get("blog_title"));
            blog.setImageUrl((String) solrDocument.get("blog_image_url"));
            blog.setSummary((String) solrDocument.get("blog_summary"));
            blog.setCreateTime((Date) solrDocument.get("blog_create_time"));
            blog.setUpdateTime((Date) solrDocument.get("blog_update_time"));
            blog.setBlogDesc((String) solrDocument.get("blog_desc"));
            //添加的商品列表
            blogList.add(blog);
        }
        //根据日期排序
        Collections.sort(blogList,new Comparator<Blog>(){
            @Override
            public int compare(Blog o1, Blog o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                Date dt1 = o1.getCreateTime();
                Date dt2 = o2.getCreateTime();
                if(dt1==null || dt2==null){
                    return 0;
                }
                if (dt1.getTime() < dt2.getTime()) {
                    return 1;
                } else if (dt1.getTime() > dt2.getTime()) {
                    return -1;
                } else {
                    return 0;
                }

            }



        });
        result.setBlogList(blogList);
        return result;
    }

}
