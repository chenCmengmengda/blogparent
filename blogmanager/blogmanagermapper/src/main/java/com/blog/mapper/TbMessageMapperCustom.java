package com.blog.mapper;

import com.blog.pojo.TbMessageCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMessageMapperCustom {
    void addForeignKey(@Param("messageId")Long messageId,@Param("myreplyId") Long myreplyId);
    List<TbMessageCustom> findAll();
    TbMessageCustom findOne(@Param("messageId")Long messageId);
}
