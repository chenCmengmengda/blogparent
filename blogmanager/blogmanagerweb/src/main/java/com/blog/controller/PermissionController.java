package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPermission;
import com.blog.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/list.do")
    @ResponseBody
    public EUDataGridResult gerPermissionList(Integer page, Integer rows) {
        EUDataGridResult result=permissionService.gerPermissionList(page,rows);
        return result;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result addPermission(@RequestBody TbPermission permission) {
        Result result=permissionService.addPermission(permission);
        return result;
    }

}
