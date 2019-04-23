package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbRole;
import com.blog.pojo.TbRoleCustom;

public interface RoleService {
    EUDataGridResult gerRoleList(Integer page,Integer rows);
    Result addRole(TbRole role);
    EUDataGridResult findOtherPermissions(Long id);
    Result addPermissionToRole(Long roleId, Long[] permissionIds);
    TbRoleCustom findRolePermissionById(Long id);
}
