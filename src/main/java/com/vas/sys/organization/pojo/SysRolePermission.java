package com.vas.sys.organization.pojo;

public class SysRolePermission {
    private String fdRoleId;

    private String fdPermissionId;

    public String getFdRoleId() {
        return fdRoleId;
    }

    public void setFdRoleId(String fdRoleId) {
        this.fdRoleId = fdRoleId == null ? null : fdRoleId.trim();
    }

    public String getFdPermissionId() {
        return fdPermissionId;
    }

    public void setFdPermissionId(String fdPermissionId) {
        this.fdPermissionId = fdPermissionId == null ? null : fdPermissionId.trim();
    }
}