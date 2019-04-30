package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbRole;
import com.blog.pojo.TbRoleCustom;
import com.blog.pojo.TbRolePermissionKey;
import com.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/list.do")
    @ResponseBody
    public EUDataGridResult getRoleList(Integer page,Integer rows){
        EUDataGridResult result=roleService.gerRoleList(page,rows);
        return result;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result addRole(@RequestBody TbRole role){
        Result result=roleService.addRole(role);
        return result;
    }


    /**
     * 查询此id的角色还可以添加的其他路径
     * @param id roleId
     * @return
     */
    @RequestMapping("/findOtherPermissions.do")
    @ResponseBody
    public EUDataGridResult findOtherPermissions(Long id){
        EUDataGridResult result=roleService.findOtherPermissions(id);
        return result;
    }

    @RequestMapping("/addPermissionToRole.do")
    @ResponseBody
    public Result addPermissionToRole(Long roleId, Long[] permissionIds){
        Result result=roleService.addPermissionToRole(roleId,permissionIds);
        return result;
    }

    /**
     * 查询此角色id的所有权限信息
     * @param id roleId
     * @return
     */
    @RequestMapping("/findRolePermissionById.do")
    @ResponseBody
    public TbRoleCustom findRolePermissionById(Long id){
        TbRoleCustom roleCustom=roleService.findRolePermissionById(id);
        return roleCustom;
    }

    @RequestMapping("/deletePermissionToRole.do")
    @ResponseBody
    public Result deletePermissionToRole(TbRolePermissionKey rolePermissionKey){
        Result result=roleService.deletePermissionToRole(rolePermissionKey);
        return result;
    }


}
