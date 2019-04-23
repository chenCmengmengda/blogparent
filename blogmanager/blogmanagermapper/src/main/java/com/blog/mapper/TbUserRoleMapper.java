package com.blog.mapper;

import com.blog.pojo.TbUserRoleExample;
import com.blog.pojo.TbUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserRoleMapper {
    long countByExample(TbUserRoleExample example);

    int deleteByExample(TbUserRoleExample example);

    int deleteByPrimaryKey(TbUserRoleKey key);

    int insert(TbUserRoleKey record);

    int insertSelective(TbUserRoleKey record);

    List<TbUserRoleKey> selectByExample(TbUserRoleExample example);

    int updateByExampleSelective(@Param("record") TbUserRoleKey record, @Param("example") TbUserRoleExample example);

    int updateByExample(@Param("record") TbUserRoleKey record, @Param("example") TbUserRoleExample example);
}