package com.blog.portal.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbMessage;
import com.blog.portal.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/list")
    @ResponseBody
    public ListDataResult getMessageMyreplyList(Integer page, Integer rows){
        ListDataResult result=messageService.getMessageMyreplyList(page,rows);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result AddMessage(@RequestBody TbMessage message){
        Result result=messageService.AddMessage(message);
        return result;
    }
}
