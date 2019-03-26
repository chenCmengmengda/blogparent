package com.blog.mapper;

import com.blog.pojo.TbPhotolist;
import com.blog.pojo.TbPhotolistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPhotolistMapper {
    long countByExample(TbPhotolistExample example);

    int deleteByExample(TbPhotolistExample example);

    int deleteByPrimaryKey(Long photoId);

    int insert(TbPhotolist record);

    int insertSelective(TbPhotolist record);

    List<TbPhotolist> selectByExample(TbPhotolistExample example);

    TbPhotolist selectByPrimaryKey(Long photoId);

    int updateByExampleSelective(@Param("record") TbPhotolist record, @Param("example") TbPhotolistExample example);

    int updateByExample(@Param("record") TbPhotolist record, @Param("example") TbPhotolistExample example);

    int updateByPrimaryKeySelective(TbPhotolist record);

    int updateByPrimaryKey(TbPhotolist record);
}