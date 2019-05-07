package com.blog.portal.controller;


import com.blog.portal.pojo.SearchResult;
import com.blog.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Created by 陈_C on 2018/7/18.
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    @ResponseBody
    public SearchResult search(@RequestParam("q")String queryString,
                         @RequestParam(defaultValue="1")Integer page) {
        if (queryString != null) {
            try {
                queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        SearchResult searchResult = searchService.search(queryString, page);


        return searchResult;

    }

}
