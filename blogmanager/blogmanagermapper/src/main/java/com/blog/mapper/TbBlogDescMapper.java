package com.blog.mapper;

import java.util.List;

import com.blog.pojo.TbBlogDesc;
import com.blog.pojo.TbBlogDescExample;
import org.apache.ibatis.annotations.Param;

public interface TbBlogDescMapper {
    long countByExample(TbBlogDescExample example);

    int deleteByExample(TbBlogDescExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(TbBlogDesc record);

    int insertSelective(TbBlogDesc record);

    List<TbBlogDesc> selectByExampleWithBLOBs(TbBlogDescExample example);

    List<TbBlogDesc> selectByExample(TbBlogDescExample example);

    TbBlogDesc selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("record") TbBlogDesc record, @Param("example") TbBlogDescExample example);

    int updateByExampleWithBLOBs(@Param("record") TbBlogDesc record, @Param("example") TbBlogDescExample example);

    int updateByExample(@Param("record") TbBlogDesc record, @Param("example") TbBlogDescExample example);

    int updateByPrimaryKeySelective(TbBlogDesc record);

    int updateByPrimaryKeyWithBLOBs(TbBlogDesc record);

    int updateByPrimaryKey(TbBlogDesc record);
}