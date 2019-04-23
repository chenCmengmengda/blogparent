package com.blog.pojo;

import java.util.List;

public class TbUserCustom extends  TbUser{
    private List<TbRoleCustom> roleCustomList;

    public List<TbRoleCustom> getRoleCustomList() {
        return roleCustomList;
    }

    public void setRoleCustomList(List<TbRoleCustom> roleCustomList) {
        this.roleCustomList = roleCustomList;
    }
}
