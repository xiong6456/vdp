package com.vas.sys.common.service.impl;

import com.vas.sys.common.mapper.SysConfigMapper;
import com.vas.sys.common.pojo.SysConfig;
import com.vas.sys.common.service.SysConfigService;
import com.vas.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysConfigServiceImpl implements SysConfigService {
	
	@Autowired
	private SysConfigMapper sysConfigMapper;

	//获取方法名
	private static String getMethodName(String fildeName) throws Exception{
	    byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
	@Override
	public int insert(SysConfig config) {
		int i=sysConfigMapper.insert(config);
		return i;
	}

	@Override
	public int update(SysConfig config) {
		SysConfig configRtn = sysConfigMapper.selectConfigByType(config.getFdType());
		if(configRtn == null){
			return sysConfigMapper.insert(config);
		}
		configRtn.setFdValue(config.getFdValue());
		return sysConfigMapper.updateByPrimaryKeySelective(configRtn);
	}

	@Override
	public String getValueByType(String fdType) {
		return sysConfigMapper.getValueByType(fdType);
	}

}
