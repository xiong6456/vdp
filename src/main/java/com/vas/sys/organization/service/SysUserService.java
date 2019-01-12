package com.vas.sys.organization.service;

import java.util.Set;

import com.vas.sys.common.pojo.Page;
import com.vas.sys.organization.pojo.SysUser;
import net.sf.json.JSONObject;

/**
 * @Description
 * @author Hevin*Xiong
 * @time 2018-2-3 上午8:46:43
 * @version 1.0.0
 */
public interface SysUserService {
	public SysUser queryUserByName(String userName) throws Exception;
    public Set<String> queryRolesByName(String userName) throws Exception;
    public Set<String> findPermissions(String userName) throws Exception;
    /**
	 * @Description 密码输入5次错误就锁帐户
	 * @param userName
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:28:54
	 */
    int lockByUserName(String userName) throws Exception;
	/**
	 * @Description 
	 * @param userName
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:28:54
	 */
	public int queryUniqueByUserName(String userName) throws Exception;
	/**
	 * @Description 
	 * @param pSysUser
	 * @author Hevin*Xiong
	 * @return 
	 * @time 2018-2-11 上午11:32:41
	 */
	public JSONObject insert(SysUser pSysUser) throws Exception;
	/**
	 * @Description 根据查询条件查询数据
	 * @param pSysUser 
	 * @author Hevin*Xiong
	 * @return 
	 * @time 2018-2-11 上午11:32:41
	 */
	public String selectBox(SysUser pSysUser) throws Exception;
	/**
	 * @Description 查询所有用户
	 * @param pageNum 当前页数
	 * @param pageSize 查询条数
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public String select(String pageNum,String pageSize) throws Exception;
	/**
	 * @Description 通过fdId查询所有用户
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public JSONObject selectById(String fdId) throws Exception;
	/**
	 * @Description 通过角色id查询已选择角色的用户
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public String selectByRoleId(String fdRoleId) throws Exception;
	/**
	 * @Description 通过角色id查询未选择角色的用户
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public String unSelectByRoleId(String fdRoleId) throws Exception;
	/**
	 * @Description 通过角色id和人员名称查询未选择角色的用户
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public String unSelectByRoleIdandName(String fdRoleId, String fdName) throws Exception;
	/**
	 * @Description 根据Ids删除数据
	 * @param ids
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public JSONObject delete(String ids) throws Exception;
	/**
	 * @Description 用户修改
	 * @param user
	 * @return 
	 * @author Hevin*Xiong
	 * @time 2018-2-24 下午8:18:25
	 */
	public JSONObject update(SysUser user) throws Exception;
	/**
	 * @Description 密码修改
	 * @param fdLoginName
	 * @param oldPsw
	 * @param newPsw
	 * @return 
	 * @author Hevin*Xiong
	 * @time 2018-2-24 下午8:18:25
	 */
	public String pswUpdate(String fdLoginName, String oldPsw, String newPsw) throws Exception;
	/**
	 * @Description 密码重置
	 * @param fdLoginName
	 * @return 
	 * @author Hevin*Xiong
	 * @time 2018-2-24 下午8:18:25
	 */
	public String pswReset(String fdLoginName) throws Exception;
	/**
	 * @Description 帐户解锁
	 * @param fdLoginName
	 * @param fdLock
	 * @return 
	 * @author Hevin*Xiong
	 * @time 2018-2-24 下午8:18:25
	 */
	public String pswOpenLock(String fdLoginName, String fdLock) throws Exception;
}
