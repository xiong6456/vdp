package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysRolePermission;
import java.util.List;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    List<SysRolePermission> selectAll();
}