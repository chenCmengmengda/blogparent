package com.blog.mapper;

import com.blog.pojo.TbPermission;
import com.blog.pojo.TbRole;
import com.blog.pojo.TbRoleCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRoleMapperCustom {
    List<TbPermission> findOtherPermissions(Long roleId);

    void addPermissionToRole(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    List<TbRoleCustom> findRoleByUserId(Long userId);

    TbRoleCustom findRolePermissionById(Long roleId);
}
