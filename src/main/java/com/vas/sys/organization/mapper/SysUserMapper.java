package com.vas.sys.organization.mapper;

import com.vas.sys.organization.pojo.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysUserMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String fdId);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    int queryUniqueByUserName(String userName);

    SysUser queryUserByName(String userName);

    /**
     * 通过用户名查找角色
     * @param userName
     * @return
     */
    Set<String> queryRolesByName(String userName);

    /**
     * 通过用户名查找角色编码
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 通过用户名锁定用户
     * @param userName
     * @return
     */
    int lockByUserName(String userName);

    /**
     * 通过pFdId锁定用户
     * @param pFdId
     * @param pStatus
     * @return
     */
    int updateStatus(@Param("pFdId")String pFdId,@Param("pStatus") String pStatus);

    /**
     * 通过用户IDS删除用户
     * @param ids
     * @return
     */
    int deleteByIds(Map<String, Object> ids);

    /**
     * 通过用户ID修改对应数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据传的条件查询用户
     * @param user
     * @return
     */
    List<SysUser> selectByUser(SysUser user);

    /**
     * 根据角色ID查询用户信息
     * @param fdRoleId
     * @return
     */
    List<Map<String, String>> selectByRoleId(String fdRoleId);

    /**
     * 根据角色ID查询未选择的用户
     * @param fdRoleId
     * @return
     */
    List<Map<String, String>> unSelectByRoleId(String fdRoleId);

    /**
     * 根据角色ID和名称查询未选择的用户
     * @param fdRoleId
     * @param fdName
     * @return
     */
    List<Map<String, String>> unSelectByRoleIdandName(
            @Param("fdRoleId") String fdRoleId, @Param("fdName") String fdName);
}