package com.blog.rest.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbMessageMapper;
import com.blog.mapper.TbMessageMapperCustom;
import com.blog.pojo.TbMessage;
import com.blog.pojo.TbMessageCustom;
import com.blog.rest.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    TbMessageMapper messageMapper;
    @Autowired
    TbMessageMapperCustom messageMapperCustom;

    /**
     * 查询评论回复
     * @param page
     * @param rows
     * @return
     */
    @Override
    public ListDataResult getMessageMyreplyList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<TbMessageCustom> list=messageMapperCustom.findAll();
        ListDataResult result=new ListDataResult();
        result.setRows(list);
        result.setPage(page);
        //取记录总条数
        PageInfo<TbMessageCustom> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        return result;
    }

    @Override
    public Result AddMessage(TbMessage message){
        message.setId(IDUtils.genItemId());
        Date date=new Date();
        message.setCreateTime(date);
        messageMapper.insert(message);
        return Result.ok();
    }


}
