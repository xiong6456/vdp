package com.vas.sys.common.service;


import com.vas.sys.common.pojo.SysConfig;

public interface SysConfigService {
	int insert(SysConfig config);
	int update(SysConfig config);
	String getValueByType(String fdType);
}
