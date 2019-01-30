package com.vas.sys.organization.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vas.sys.common.pojo.Page;
import com.vas.sys.organization.mapper.SysUserMapper;
import com.vas.sys.organization.pojo.SysUser;
import com.vas.sys.organization.service.SysUserService;
import com.vas.sys.organization.util.JSONUtil;
import com.vas.sys.organization.util.PasswordHelper;
import com.vas.sys.organization.util.RetryLimitHashedCredentialsMatcher;
import com.vas.sys.organization.util.StringUtil;
import com.vas.util.IDGenerator;
import com.vas.util.UserUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description 用户管理
 * @author Hevin*Xiong
 * @time 2018-2-2 下午11:55:01
 * @version 1.0.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	private static final Logger logger = LoggerFactory
			.getLogger(SysUserServiceImpl.class);
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private RetryLimitHashedCredentialsMatcher openCache;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#queryUserByName(java.lang.String)
	 */
	@Override
	public SysUser queryUserByName(String userName) throws Exception {
		return sysUserMapper.queryUserByName(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#queryRolesByName(java.lang.String)
	 */
	@Override
	public Set<String> queryRolesByName(String userName) throws Exception {
		return sysUserMapper.queryRolesByName(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#findPermissions(java.lang.String)
	 */
	@Override
	public Set<String> findPermissions(String userName) throws Exception {
		return sysUserMapper.findPermissions(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#lockByUserName(java.lang.String)
	 */
	@Override
	public int lockByUserName(String userName) throws Exception {
		return sysUserMapper.lockByUserName(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#queryUniqueByUserName(java.lang
	 * .String)
	 */
	@Override
	public int queryUniqueByUserName(String userName) throws Exception {
		return sysUserMapper.queryUniqueByUserName(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#insert(SysUser)
	 */
	@Override
	public JSONObject insert(SysUser pSysUser) throws Exception {
		JSONObject jsonObject = new JSONObject();
		try {
			String fdLoginName = pSysUser.getFdLoginName();
			if (fdLoginName == null || "".equals(fdLoginName)) {
				jsonObject.put("flag", "error");
				jsonObject.put("msg", "用户名不能为空！");
				return jsonObject;
			}
			int checkUnique = sysUserMapper.queryUniqueByUserName(fdLoginName);
			if (checkUnique != 0) {
				jsonObject.put("flag", "error");
				jsonObject.put("msg", "用户名已存在！");
				return jsonObject;
			}
			if(StringUtil.isNull(pSysUser.getFdPassword())){
				pSysUser.setFdPassword("123456");
			}
			PasswordHelper tPasswordHelper = new PasswordHelper();
			tPasswordHelper.encryptPassword(pSysUser);
			pSysUser.setFdLocked("0");
			pSysUser.setFdId(IDGenerator.generateID());
			pSysUser.setDocCreatorId(UserUtil.getUser().getFdId());
			pSysUser.setDocAlterorId(UserUtil.getUser().getFdId());
			pSysUser.setDocCreateTime(new Date());
			pSysUser.setDocAlterTime(new Date());
			sysUserMapper.insert(pSysUser);
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "提交成功！");
		} catch (Exception e) {
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "提交失败，原因是：" + e.getMessage());
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SysUserService#select()
	 */
	@Override
	public String select(String pageNum,String pageSize) throws Exception{
		JSONObject jsonObject = new JSONObject();
		JSONObject rtnJson = new JSONObject();
		rtnJson.put("code",0);
		rtnJson.put("msg","");

		// 在查询方法调用之前，调用分页插件的静态方法，中间最好不要隔任何代码
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
		List<SysUser> userList = sysUserMapper.selectAll();
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(userList);
		rtnJson.put("count",pageInfo.getTotal());
		rtnJson.put("data",pageInfo.getList());
		return rtnJson.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SysUserService#delete(java.lang.String[])
	 */
	@Override
	public JSONObject delete(String ids) throws Exception {
		JSONObject jsonObject = new JSONObject();
		try {
			String[] fdIds = ids.split(",");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", fdIds);
			sysUserMapper.deleteByIds(map);
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "删除成功！");
		} catch (Exception e) {
			logger.info("删除失败，原因是：" + e.getMessage());
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "删除失败，原因是：" + e.getMessage());
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SysUserService#selectById(java.lang.String)
	 */
	@Override
	public JSONObject selectById(String fdId) throws Exception {
		JSONObject jsonObject = new JSONObject();
		SysUser user = sysUserMapper.selectByPrimaryKey(fdId);
		jsonObject = JSONObject.fromObject(user);
		return jsonObject;
	}

	@Override
	public JSONObject update(SysUser user) {
		JSONObject jsonObject = new JSONObject();
		try {
			sysUserMapper.updateByPrimaryKeySelective(user);
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "修改成功！");
		} catch (Exception e) {
			logger.info("修改失败，原因是：" + e.getMessage());
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "修改失败，原因是：" + e.getMessage());
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SysUserService#selectBox(java.lang.String)
	 */
	@Override
	public String selectBox(SysUser pSysUser) throws Exception {
		JSONObject jsonObject = new JSONObject();
//		SysUserExample tSysUserExample = new SysUserExample();
//		Criteria criteria = tSysUserExample.createCriteria();
//		if (pSysUser.getFdDeptId() != null
//				&& !"".equals(pSysUser.getFdDeptId())) {
//			criteria.andFdDeptIdEqualTo(pSysUser.getFdDeptId());
//		}
//		if (pSysUser.getFdName() != null && !"".equals(pSysUser.getFdName())) {
//			criteria.andFdNameLike("%" + pSysUser.getFdName() + "%");
//		}
//		List<SysUser> selectAll = sysUserMapper
//				.selectByExample(tSysUserExample);
		List<SysUser> selectAll =  sysUserMapper
				.selectByUser(pSysUser);
		jsonObject.put("total", selectAll.size());
		jsonObject.put("rows", selectAll);
		String json = JSONUtil.convertJSONString(jsonObject);
		return json;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#selectByRoleId(java.lang.String)
	 */
	@Override
	public String selectByRoleId(String fdRoleId) throws Exception {
		String rtnStr = "";
		try {
			JSONArray jsonArray = new JSONArray();
			List<Map<String, String>> userinfo = sysUserMapper
					.selectByRoleId(fdRoleId);
			jsonArray = JSONArray.fromObject(userinfo);
			rtnStr = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}


	/* (non-Javadoc)
	 * @see SysUserService#unSelectByRoleId(java.lang.String)
	 */
	@Override
	public String unSelectByRoleId(String fdRoleId) throws Exception {
		String rtnStr = "";
		try {
			JSONArray jsonArray = new JSONArray();
			List<Map<String, String>> userinfo = sysUserMapper
					.unSelectByRoleId(fdRoleId);
			jsonArray = JSONArray.fromObject(userinfo);
			rtnStr = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}
	
	/* (non-Javadoc)
	 * @see SysUserService#unSelectByRoleIdandName(java.lang.String, java.lang.String)
	 */
	@Override
	public String unSelectByRoleIdandName(String fdRoleId, String fdName) throws Exception {
		String rtnStr = "";
		try {
			fdName = "%" + fdName + "%";
			JSONArray jsonArray = new JSONArray();
			List<Map<String, String>> userinfo = sysUserMapper
					.unSelectByRoleIdandName(fdRoleId,fdName);
			jsonArray = JSONArray.fromObject(userinfo);
			rtnStr = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SysUserService#pswUpdate(SysUser
	 * )
	 */
	@Override
	public String pswUpdate(String fdLoginName, String oldPsw, String newPsw) throws Exception {
		JSONObject jsonObject = new JSONObject();
		SysUser queryUserByName = sysUserMapper.queryUserByName(fdLoginName);
		/**检验输入的用户名是否存在*/
		if (queryUserByName == null) {
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "修改失败，原因是：用户名不存在！");
			return jsonObject.toString();
		}
		/**检验原密码是否正确*/
		PasswordHelper tPasswordHelper = new PasswordHelper();
		boolean flag = tPasswordHelper.checkPassword(queryUserByName.getFdSalt(),
				queryUserByName.getFdPassword(), oldPsw);
		if (flag == false) {
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "修改失败，原因是：原密码错误！");
			return jsonObject.toString();
		}
		/**修改原密码*/
		newPsw = tPasswordHelper.encryptPassword(queryUserByName.getFdSalt(),newPsw);
		queryUserByName.setFdPassword(newPsw);
		sysUserMapper.updateByPrimaryKeySelective(queryUserByName);
		jsonObject.put("flag", "success");
		jsonObject.put("msg", "修改成功！");
		return jsonObject.toString();
	}

	/* (non-Javadoc)
	 * @see SysUserService#pswReset(java.lang.String)
	 */
	@Override
	public String pswReset(String fdLoginName) throws Exception {
		JSONObject jsonObject = new JSONObject();
		SysUser queryUserByName = sysUserMapper.queryUserByName(fdLoginName);
		if (queryUserByName == null) {
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "重置失败，原因是：用户名不存在！");
			return jsonObject.toString();
		}
		PasswordHelper tPasswordHelper = new PasswordHelper();
		String resetPsw="123456";
		resetPsw = tPasswordHelper.encryptPassword(queryUserByName.getFdSalt(),resetPsw);
		queryUserByName.setFdPassword(resetPsw);
		sysUserMapper.updateByPrimaryKeySelective(queryUserByName);
		jsonObject.put("flag", "success");
		jsonObject.put("msg", "重置成功！");
		return jsonObject.toString();
	}

	/* (non-Javadoc)
	 * @see SysUserService#pswUpdate(java.lang.String, java.lang.String)
	 */
	@Override
	public String pswOpenLock(String fdLoginName, String fdLocked) throws Exception {
		JSONObject jsonObject = new JSONObject();
		SysUser queryUserByName = sysUserMapper.queryUserByName(fdLoginName);
		if (queryUserByName == null) {
			jsonObject.put("flag", "error");
			jsonObject.put("msg", "解锁失败，原因是：用户名不存在！");
			return jsonObject.toString();
		}
		
		try {
			openCache.openLock(fdLoginName);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		PasswordHelper tPasswordHelper = new PasswordHelper();
		String resetPsw="123456";
		resetPsw = tPasswordHelper.encryptPassword(queryUserByName.getFdSalt(),resetPsw);
		queryUserByName.setFdPassword(resetPsw);
		
		queryUserByName.setFdLocked(fdLocked);
		sysUserMapper.updateByPrimaryKeySelective(queryUserByName);
		jsonObject.put("flag", "success");
		jsonObject.put("msg", "解锁成功！");
		return jsonObject.toString();
	}

	@Override
	public String updateStatus(String pFdId,String pStatus) throws Exception {
		JSONObject jsonObject = new JSONObject();
		try{
			sysUserMapper.updateStatus(pFdId,pStatus);
			jsonObject.put("flag", "success");
			if("1".equals(pStatus)){
				jsonObject.put("msg", "锁定成功！");
			}else{
				jsonObject.put("msg", "解锁成功！");
			}
		}catch (Exception e){
			jsonObject.put("flag", "success");
			jsonObject.put("msg", "锁定失败！");
		}

		return jsonObject.toString();
	}

}
