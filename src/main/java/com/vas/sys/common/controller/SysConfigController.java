package com.vas.sys.common.controller;

import com.vas.sys.common.pojo.SysConfig;
import com.vas.sys.common.service.SysConfigService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 参数
 * @author HevinXiong
 *
 */
@Controller
@RequestMapping("/sysConfig")
public class SysConfigController {
	private static final Logger logger = LoggerFactory
			.getLogger(SysConfigController.class);
	
	@Autowired
    private SysConfigService sysConfigService;
	
	@ResponseBody
	@RequestMapping("/select")
    public String select(String type, HttpServletResponse response){
		String rtnStr = new String();
		try {
			rtnStr = sysConfigService.getValueByType(type);
		} catch (Exception e) {
			logger.info("查询失败，原因是：" + e.getMessage());
		}
		return rtnStr.toString();
    }

	@ResponseBody
	@RequestMapping("/insert")
	public String insert(SysConfig config){
		JSONObject jsonObject = new JSONObject();
		int i = sysConfigService.insert(config);
		if(i>0){
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "参数配置成功！");
		}else{
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "参数配置失败！");
		}
		return jsonObject.toString();
	}

	@ResponseBody
	@RequestMapping("/update")
    public String update(SysConfig config){
		JSONObject jsonObject = new JSONObject();
		int i = sysConfigService.update(config);
		if(i>0){
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "参数配置成功！");
		}else{
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "参数配置失败！");
		}
		return jsonObject.toString();
    }
}
