package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysPermission;
import java.util.List;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(SysPermission record);

    SysPermission selectByPrimaryKey(String fdId);

    List<SysPermission> selectAll();

    int updateByPrimaryKey(SysPermission record);
}