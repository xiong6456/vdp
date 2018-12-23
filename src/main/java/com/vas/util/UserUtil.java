package com.vas.util;
import com.vas.sys.organization.pojo.SysUser;
import org.apache.shiro.SecurityUtils;

public abstract class UserUtil {
    /**
     * 在程序中使用，获取当前登录用户
     *
     * @return
     */
    public static SysUser getUser() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        SysUser sysUser = (SysUser)principal;
        return sysUser;
    }
}
