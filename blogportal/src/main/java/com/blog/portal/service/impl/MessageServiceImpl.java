package com.blog.portal.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.HttpClientUtil;
import com.blog.common.util.JsonUtils;
import com.blog.pojo.TbMessage;
import com.blog.portal.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${MESSAGE_LIST_URL}")
    private String MESSAGE_LIST_URL;
    @Value("${MESSAGE_ADD_URL}")
    private String MESSAGE_ADD_URL;

    @Override
    public ListDataResult getMessageMyreplyList(Integer page, Integer rows) {
        String json= HttpClientUtil.doGet(REST_BASE_URL+MESSAGE_LIST_URL+"?page="+page+"&rows="+rows);
        ListDataResult result= JsonUtils.jsonToPojo(json,ListDataResult.class);
        return result;
    }

    @Override
    public Result AddMessage(TbMessage message) {
        String jsonStr=JsonUtils.objectToJson(message);
        String json= HttpClientUtil.doPostJson(REST_BASE_URL+MESSAGE_ADD_URL, jsonStr);
        Result result= JsonUtils.jsonToPojo(json,Result.class);
        return result;
    }
}
