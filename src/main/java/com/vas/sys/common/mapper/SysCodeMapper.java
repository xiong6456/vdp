package com.vas.sys.common.mapper;

import com.vas.sys.common.pojo.SysCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysCodeMapper {
    int deleteByPrimaryKey(String codeId);

    int insert(SysCode record);

    int insertSelective(SysCode record);

    SysCode selectByPrimaryKey(String codeId);

    List<SysCode> selectByCodeType(String codeType);

    int updateByPrimaryKeySelective(SysCode record);

    int updateByPrimaryKey(SysCode record);
    
    int deleteByIds(Map<String, Object> ids);
    
    List<SysCode> selectByTypeAndName(@Param("type") String type, @Param("name") String name);
}