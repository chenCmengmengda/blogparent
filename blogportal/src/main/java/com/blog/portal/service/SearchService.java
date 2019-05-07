package com.blog.portal.service;

import com.blog.portal.pojo.SearchResult;

/**
 * Created by 陈_C on 2018/7/18.
 */
public interface SearchService {
    SearchResult search(String queryString, int page);
}
