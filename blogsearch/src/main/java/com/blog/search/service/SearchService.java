package com.blog.search.service;

import com.blog.search.pojo.SearchResult;

/**
 * Created by 陈_C on 2018/7/18.
 */
public interface SearchService {
    SearchResult search(String queryString, int page, int rows) throws Exception;
}
