package com.vas.sys.organization.pojo;

import com.vas.sys.common.BasePojo;

import java.util.Date;

public class SysDept extends BasePojo {
    private String fdId;

    private String fdName;

    private String fdType;

    private String fdParentId;

    private String fdMajorId;

    private String fdMinorId;

    private String fdChildCount;

    private Integer fdOrder;

    private String fdBak1;

    private String fdBak2;

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

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName == null ? null : fdName.trim();
    }

    public String getFdType() {
        return fdType;
    }

    public void setFdType(String fdType) {
        this.fdType = fdType == null ? null : fdType.trim();
    }

    public String getFdParentId() {
        return fdParentId;
    }

    public void setFdParentId(String fdParentId) {
        this.fdParentId = fdParentId == null ? null : fdParentId.trim();
    }

    public String getFdMajorId() {
        return fdMajorId;
    }

    public void setFdMajorId(String fdMajorId) {
        this.fdMajorId = fdMajorId == null ? null : fdMajorId.trim();
    }

    public String getFdMinorId() {
        return fdMinorId;
    }

    public void setFdMinorId(String fdMinorId) {
        this.fdMinorId = fdMinorId == null ? null : fdMinorId.trim();
    }

    public String getFdChildCount() {
        return fdChildCount;
    }

    public void setFdChildCount(String fdChildCount) {
        this.fdChildCount = fdChildCount == null ? null : fdChildCount.trim();
    }

    public Integer getFdOrder() {
        return fdOrder;
    }

    public void setFdOrder(Integer fdOrder) {
        this.fdOrder = fdOrder;
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