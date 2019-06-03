package com.blog.mapper;

import com.blog.pojo.TbBlogCat;
import com.blog.pojo.TbBlogCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBlogCatMapper {
    long countByExample(TbBlogCatExample example);

    int deleteByExample(TbBlogCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBlogCat record);

    int insertSelective(TbBlogCat record);

    List<TbBlogCat> selectByExample(TbBlogCatExample example);

    TbBlogCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBlogCat record, @Param("example") TbBlogCatExample example);

    int updateByExample(@Param("record") TbBlogCat record, @Param("example") TbBlogCatExample example);

    int updateByPrimaryKeySelective(TbBlogCat record);

    int updateByPrimaryKey(TbBlogCat record);
}