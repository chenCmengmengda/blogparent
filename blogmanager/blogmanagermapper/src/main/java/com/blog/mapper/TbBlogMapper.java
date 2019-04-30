package com.blog.mapper;

import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBlogMapper {
    long countByExample(TbBlogExample example);

    int deleteByExample(TbBlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBlog record);

    int insertSelective(TbBlog record);

    List<TbBlog> selectByExampleWithBLOBs(TbBlogExample example);

    List<TbBlog> selectByExample(TbBlogExample example);

    TbBlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByExample(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByPrimaryKeySelective(TbBlog record);

    int updateByPrimaryKeyWithBLOBs(TbBlog record);

    int updateByPrimaryKey(TbBlog record);
}