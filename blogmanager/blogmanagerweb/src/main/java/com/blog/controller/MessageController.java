package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbMessageCustom;
import com.blog.service.MessageService;
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

    @RequestMapping("/list.do")
    @ResponseBody
    public EUDataGridResult getMessageList(Integer page, Integer rows){
        EUDataGridResult result=messageService.getMessageList(page,rows);
        return result;
    }

    @RequestMapping("/findOne.do")
    @ResponseBody
    public Result findOneMessage(Long messageId){
        Result result=messageService.findOneMessage(messageId);
        return result;
    }

    @RequestMapping("/addReply.do")
    @ResponseBody
    public Result addReply(@RequestBody TbMessageCustom messageCustom){
        Result result=messageService.addReply(messageCustom);
        return Result.ok();
    }
}
