package com.vas.sys.organization.pojo;

import com.vas.sys.common.pojo.BasePojo;

import java.util.Date;

public class SysRole extends BasePojo {
    private String fdId;

    private String fdCode;

    private String fdName;

    private String fdDescription;

    private String fdAvailable;

    private Integer fdOrder;

    private Long docOrder;

    private String docCreatorId;

    private String docAlterorId;

    private Date docCreateTime;

    private Date docAlterTime;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId == null ? null : fdId.trim();
    }

    public String getFdCode() {
        return fdCode;
    }

    public void setFdCode(String fdCode) {
        this.fdCode = fdCode == null ? null : fdCode.trim();
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName == null ? null : fdName.trim();
    }

    public String getFdDescription() {
        return fdDescription;
    }

    public void setFdDescription(String fdDescription) {
        this.fdDescription = fdDescription == null ? null : fdDescription.trim();
    }

    public String getFdAvailable() {
        return fdAvailable;
    }

    public void setFdAvailable(String fdAvailable) {
        this.fdAvailable = fdAvailable == null ? null : fdAvailable.trim();
    }

    public Integer getFdOrder() {
        return fdOrder;
    }

    public void setFdOrder(Integer fdOrder) {
        this.fdOrder = fdOrder;
    }

    public Long getDocOrder() {
        return docOrder;
    }

    public void setDocOrder(Long docOrder) {
        this.docOrder = docOrder;
    }

    public String getDocCreatorId() {
        return docCreatorId;
    }

    public void setDocCreatorId(String docCreatorId) {
        this.docCreatorId = docCreatorId == null ? null : docCreatorId.trim();
    }

    public String getDocAlterorId() {
        return docAlterorId;
    }

    public void setDocAlterorId(String docAlterorId) {
        this.docAlterorId = docAlterorId == null ? null : docAlterorId.trim();
    }

    public Date getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(Date docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public Date getDocAlterTime() {
        return docAlterTime;
    }

    public void setDocAlterTime(Date docAlterTime) {
        this.docAlterTime = docAlterTime;
    }
}