package com.blog.search.controller;


import com.blog.common.pojo.Result;
import com.blog.common.util.ExceptionUtil;
import com.blog.search.pojo.SearchResult;
import com.blog.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 陈_C on 2018/7/18.
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/query", method= RequestMethod.GET)
    @ResponseBody
    public Result search(@RequestParam("q")String queryString,
                               @RequestParam(defaultValue="1")Integer page,
                               @RequestParam(defaultValue="10")Integer rows) {
        //查询条件不能为空
        if (StringUtils.isBlank(queryString)) {
            return Result.build(400, "查询条件不能为空");
        }
        SearchResult searchResult = null;
        try {
            queryString = new String(queryString.getBytes("iso8859-1"),
                    "utf-8");
            searchResult = searchService.search(queryString, page, rows);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, ExceptionUtil.getStackTrace(e));
        }
        return Result.ok(searchResult);

    }

}
