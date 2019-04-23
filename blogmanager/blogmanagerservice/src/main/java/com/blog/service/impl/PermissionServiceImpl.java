package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbPermissionMapper;
import com.blog.pojo.TbPermission;
import com.blog.pojo.TbPermissionExample;
import com.blog.pojo.TbRole;
import com.blog.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    TbPermissionMapper permissionMapper;

    @Override
    public EUDataGridResult gerPermissionList(Integer page, Integer rows) {
        TbPermissionExample example=new TbPermissionExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbPermission> list=permissionMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbPermission> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Result addPermission(TbPermission permission) {
        permission.setId(IDUtils.genItemId());
        permissionMapper.insert(permission);
        return Result.ok();
    }
}
