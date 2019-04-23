package com.blog.mapper;

import com.blog.pojo.TbRolePermissionExample;
import com.blog.pojo.TbRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRolePermissionMapper {
    long countByExample(TbRolePermissionExample example);

    int deleteByExample(TbRolePermissionExample example);

    int deleteByPrimaryKey(TbRolePermissionKey key);

    int insert(TbRolePermissionKey record);

    int insertSelective(TbRolePermissionKey record);

    List<TbRolePermissionKey> selectByExample(TbRolePermissionExample example);

    int updateByExampleSelective(@Param("record") TbRolePermissionKey record, @Param("example") TbRolePermissionExample example);

    int updateByExample(@Param("record") TbRolePermissionKey record, @Param("example") TbRolePermissionExample example);
}