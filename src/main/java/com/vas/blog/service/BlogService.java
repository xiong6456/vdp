package com.vas.blog.service;

import com.vas.blog.pojo.BlogMain;
import com.vas.sys.organization.pojo.SysUser;
import net.sf.json.JSONObject;

import java.util.Set;

/**
 * @Description
 * @author Hevin*Xiong
 * @time 2018-2-3 上午8:46:43
 * @version 1.0.0
 */
public interface BlogService {
	public JSONObject insert(BlogMain pBlog) throws Exception;
	/**
	 * @Description 根据查询条件查询数据
	 * @param pBlog
	 * @author Hevin*Xiong
	 * @return 
	 * @time 2018-2-11 上午11:32:41
	 */
	public String selectBox(BlogMain pBlog) throws Exception;
	/**
	 * @Description 通过用户id查询数据
	 * @param pageNum 当前页数
	 * @param pageSize 查询条数
	 * @author Hevin*Xiong
	 * @time 2018-2-11 上午11:32:41
	 */
	public String selectByUserId(String pageNum, String pageSize) throws Exception;
}
