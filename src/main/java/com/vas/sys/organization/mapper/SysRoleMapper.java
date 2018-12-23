package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysRole;
import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String fdId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);
}