package com.vas.sys.common.pojo;

public class SysConfig extends BasePojo {
    private String fdId;

    private String fdLocked;

    private String fdType;

    private String fdValue;

    private String fdBak1;

    private String fdBak2;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId == null ? null : fdId.trim();
    }

    public String getFdType() {
        return fdType;
    }

    public void setFdType(String fdType) {
        this.fdType = fdType == null ? null : fdType.trim();
    }

    public String getFdValue() {
        return fdValue;
    }

    public void setFdValue(String fdValue) {
        this.fdValue = fdValue == null ? null : fdValue.trim();
    }

    public String getFdBak1() {
        return fdBak1;
    }

    public void setFdBak1(String fdBak1) {
        this.fdBak1 = fdBak1 == null ? null : fdBak1.trim();
    }

    public String getFdBak2() {
        return fdBak2;
    }

    public void setFdBak2(String fdBak2) {
        this.fdBak2 = fdBak2 == null ? null : fdBak2.trim();
    }

    public String getFdLocked() {
        return fdLocked;
    }

    public void setFdLocked(String fdLocked) {
        this.fdLocked = fdLocked;
    }
}