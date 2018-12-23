package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysUserRole;
import java.util.List;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    List<SysUserRole> selectAll();
}