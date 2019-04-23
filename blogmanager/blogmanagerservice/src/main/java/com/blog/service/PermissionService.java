package com.blog.service;


import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPermission;
import com.blog.pojo.TbRole;

public interface PermissionService {
    EUDataGridResult gerPermissionList(Integer page, Integer rows);
    Result addPermission(TbPermission permission);
}
