package com.blog.mapper;

import com.blog.pojo.TbMyreply;
import com.blog.pojo.TbMyreplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMyreplyMapper {
    long countByExample(TbMyreplyExample example);

    int deleteByExample(TbMyreplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbMyreply record);

    int insertSelective(TbMyreply record);

    List<TbMyreply> selectByExampleWithBLOBs(TbMyreplyExample example);

    List<TbMyreply> selectByExample(TbMyreplyExample example);

    TbMyreply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbMyreply record, @Param("example") TbMyreplyExample example);

    int updateByExampleWithBLOBs(@Param("record") TbMyreply record, @Param("example") TbMyreplyExample example);

    int updateByExample(@Param("record") TbMyreply record, @Param("example") TbMyreplyExample example);

    int updateByPrimaryKeySelective(TbMyreply record);

    int updateByPrimaryKeyWithBLOBs(TbMyreply record);

    int updateByPrimaryKey(TbMyreply record);
}