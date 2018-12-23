package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysDept;
import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(String fdId);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);
}