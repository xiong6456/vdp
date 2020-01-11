package com.vas.blog.pojo;

import java.util.Date;

public class BlogMain {
    private String fdId;

    private String docSubject;

    private Integer fdContent;

    private String fdCateId;

    private String fdPublish;

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

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject == null ? null : docSubject.trim();
    }

    public Integer getFdContent() {
        return fdContent;
    }

    public void setFdContent(Integer fdContent) {
        this.fdContent = fdContent;
    }

    public String getFdCateId() {
        return fdCateId;
    }

    public void setFdCateId(String fdCateId) {
        this.fdCateId = fdCateId == null ? null : fdCateId.trim();
    }

    public String getFdPublish() {
        return fdPublish;
    }

    public void setFdPublish(String fdPublish) {
        this.fdPublish = fdPublish == null ? null : fdPublish.trim();
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