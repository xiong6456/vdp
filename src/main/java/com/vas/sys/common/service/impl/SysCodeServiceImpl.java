package com.vas.sys.common.service.impl;

import com.vas.sys.common.mapper.SysCodeMapper;
import com.vas.sys.common.pojo.SysCode;
import com.vas.sys.common.service.SysCodeService;
import com.vas.util.JSONUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @author Hevin*Xiong
 * @time 2018-2-28 下午7:29:15
 * @version 1.0.0
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {
	@Autowired
	private SysCodeMapper sysCodeMapper;


	/* (non-Javadoc)
	 * @see com.zero.service.sys.SysCodeService#insert(com.zero.pojo.sys.SysCode)
	 */
	@Override
	public String insert(SysCode pSysCode) {
		JSONObject jsonObject = new JSONObject();
		try {
			sysCodeMapper.insert(pSysCode);
			jsonObject.put("flag", "success");
        	jsonObject.put("msg", "添加成功！");
		} catch (Exception e) {
			jsonObject.put("flag", "error");
        	jsonObject.put("msg", "添加失败，原因是："+e.getMessage());
		}
		return jsonObject.toString();
	}

	/* (non-Javadoc)
	 * @see com.zero.service.sys.SysCodeService#delete(java.lang.String)
	 */
	@Override
	public String delete(String ids) {
		JSONObject jsonObject = new JSONObject();
		try {
			String[] codeIds = ids.split(",");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", codeIds);
			sysCodeMapper.deleteByIds(map);
			jsonObject.put("flag", "success");
        	jsonObject.put("msg", "删除成功！");
		} catch (Exception e) {
			jsonObject.put("flag", "error");
        	jsonObject.put("msg", "删除失败，原因是："+e.getMessage());
		}
		return jsonObject.toString();
	}

	/* (non-Javadoc)
	 * @see com.zero.service.sys.SysCodeService#update(com.zero.pojo.sys.SysCode)
	 */
	@Override
	public String update(SysCode pSysCode) {
		JSONObject jsonObject = new JSONObject();
		try {
			sysCodeMapper.updateByPrimaryKeySelective(pSysCode);
			jsonObject.put("flag", "success");
        	jsonObject.put("msg", "修改成功！");
		} catch (Exception e) {
			jsonObject.put("flag", "error");
        	jsonObject.put("msg", "修改失败，原因是："+e.getMessage());
		}
		return jsonObject.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zero.service.sys.SysCodeService#select(java.lang.String)
	 */
	@Override
	public String select(String codeType) {
		List<SysCode> selectByExample = sysCodeMapper.selectByCodeType(codeType);
		String strCode = "";
		if (selectByExample.size() != 0) {
			strCode = buildStrCode(selectByExample);
		}
		return strCode;
	}

	/**
	 * @Description 拼接json格式的字符串，如[{"id":1,"text":"text1"},{"id":2,"text":"text2"}]
	 * @param selectByExample
	 * @return strCode
	 * @author Hevin*Xiong
	 * @time 2018-2-28 下午7:55:38
	 */
	public String buildStrCode(List<SysCode> selectByExample) {
		StringBuffer temp = new StringBuffer("[");
		String strCode = "";
		for (SysCode sysCode : selectByExample) {
			temp.append("{\"id\":\"" + sysCode.getCodeId() + "\"");
			temp.append(",\"text\":\"" + sysCode.getCodeName() + "\"},");
		}
		strCode = temp.substring(0, temp.lastIndexOf(","));
		strCode = strCode+"]";
		return strCode;
	}
	

	/* (non-Javadoc)
	 * @see com.zero.service.sys.SysCodeService#selectByCodeId(java.lang.String)
	 */
	@Override
	public String selectByCodeId(String codeId) {
		JSONObject jsonObject = new JSONObject();
		try {
			SysCode sysCode = sysCodeMapper.selectByPrimaryKey(codeId);
			jsonObject = JSONObject.fromObject(sysCode);
			jsonObject.put("flag", "success");
		} catch (Exception e) {
			jsonObject.put("flag", "error");
        	jsonObject.put("msg", "查询失败，原因是："+e.getMessage());
		}
		return JSONUtil.convertJSONString(jsonObject);
	}

	/* (non-Javadoc)
	 * @see com.zero.service.sys.SysCodeService#selectBox(com.zero.pojo.sys.SysCode)
	 */
	@Override
	public String selectBox(SysCode pSysCode) {
		JSONObject jsonObject = new JSONObject();

		String json = JSONUtil.convertJSONString(jsonObject);
		return json;
	}

}
