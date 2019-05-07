package com.blog.portal.service.impl;


import com.blog.common.pojo.Result;
import com.blog.common.util.HttpClientUtil;
import com.blog.portal.pojo.SearchResult;
import com.blog.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈_C on 2018/7/18.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public SearchResult search(String queryString, int page) {
        // 调用taotao-search的服务
        //查询参数
        Map<String, String> param = new HashMap<>();
        param.put("q", queryString);
        param.put("page", page + "");
        try {
            //调用服务
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            //把字符串转换成java对象
            Result result = Result.formatToPojo(json, SearchResult.class);
            if (result.getStatus() == 200) {
                SearchResult sraechResult = (SearchResult) result.getData();
                return sraechResult;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
