package com.blog.mapper;

import com.blog.pojo.TbPermission;

import java.util.List;

public interface TbPermissionMapperCustom {
    List<TbPermission> findPermissionByRoleId(Long roleId);
}
