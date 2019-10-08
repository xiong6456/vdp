package com.vas.sys.common.mapper;

import com.vas.sys.common.pojo.SysConfig;

import java.util.List;

public interface SysConfigMapper {

    int deleteByPrimaryKey(String fdId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(String fdId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
    
    int insertInfoBatch(List<SysConfig> sysConfigs);
    
    String getValueByType(String fdType);
}