package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbRole;
import com.blog.pojo.TbRoleCustom;
import com.blog.pojo.TbRolePermissionKey;

public interface RoleService {
    EUDataGridResult gerRoleList(Integer page,Integer rows);
    Result addRole(TbRole role);
    EUDataGridResult findOtherPermissions(Long id);
    Result addPermissionToRole(Long roleId, Long[] permissionIds);
    TbRoleCustom findRolePermissionById(Long id);
    Result deletePermissionToRole(TbRolePermissionKey rolePermissionKey);
}
