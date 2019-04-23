package com.blog.portal.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.util.HttpClientUtil;
import com.blog.common.util.JsonUtils;
import com.blog.portal.service.PhotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${PHOTO_LIST_URL}")
    private String PHOTO_LIST_URL;


    @Override
    public ListDataResult getPhotoList(Integer page, Integer rows) {
        String json= HttpClientUtil.doGet(REST_BASE_URL+PHOTO_LIST_URL+"?page="+page+"&rows="+rows);
        ListDataResult result= JsonUtils.jsonToPojo(json,ListDataResult.class);
        return result;
    }
}
