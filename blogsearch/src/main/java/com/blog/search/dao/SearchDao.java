package com.blog.search.dao;

import com.blog.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by 陈_C on 2018/7/18.
 */
public interface SearchDao {
    SearchResult search(SolrQuery query) throws Exception;
}
