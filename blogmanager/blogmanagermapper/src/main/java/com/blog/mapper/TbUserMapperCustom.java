package com.blog.mapper;

import com.blog.pojo.TbRole;
import com.blog.pojo.TbUser;
import com.blog.pojo.TbUserCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapperCustom {
    int editPassword(TbUser user);

    List<TbRole> findOtherRoles(Long userId);

    void addRoleToUser(@Param("userId") Long userId, @Param("roleId") Long roleId);

    TbUserCustom findUserRolePermissionById(Long id);
}
