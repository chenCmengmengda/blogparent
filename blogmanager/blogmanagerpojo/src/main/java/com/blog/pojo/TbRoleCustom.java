package com.blog.pojo;

import java.util.List;

public class TbRoleCustom extends TbRole {
    private List<TbPermission> permissionList;

    public List<TbPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<TbPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
