package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbMessage;
import com.blog.pojo.TbMessageCustom;

public interface MessageService {
    EUDataGridResult getMessageList(Integer page, Integer rows);
    Result findOneMessage(Long messageId);
    Result addReply(TbMessageCustom messageCustom);
}
