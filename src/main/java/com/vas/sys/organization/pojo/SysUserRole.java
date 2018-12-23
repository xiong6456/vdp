package com.vas.sys.organization.pojo;

public class SysUserRole {
    private String fdUserId;

    private String fdRoleId;

    public String getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(String fdUserId) {
        this.fdUserId = fdUserId == null ? null : fdUserId.trim();
    }

    public String getFdRoleId() {
        return fdRoleId;
    }

    public void setFdRoleId(String fdRoleId) {
        this.fdRoleId = fdRoleId == null ? null : fdRoleId.trim();
    }
}