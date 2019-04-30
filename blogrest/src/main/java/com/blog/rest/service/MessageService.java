package com.blog.rest.service;


import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbMessage;

public interface MessageService {
    ListDataResult getMessageMyreplyList(Integer page, Integer rows);
    Result AddMessage(TbMessage message);
}
