package com.vas.blog.pojo;

import com.vas.sys.common.pojo.BasePojo;

import java.util.Date;

public class BlogMain extends BasePojo {
    private String docSubject;

    private String fdCateId;

    private String fdPublish;

    private String fdContent;

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject == null ? null : docSubject.trim();
    }

    public String getFdCateId() {
        return fdCateId;
    }

    public void setFdCateId(String fdCateId) {
        this.fdCateId = fdCateId == null ? null : fdCateId.trim();
    }

    public String getFdPublish() {
        if (fdPublish == null) {
            fdPublish = "0";
        }
        return fdPublish;
    }

    public void setFdPublish(String fdPublish) {
        this.fdPublish = fdPublish == null ? null : fdPublish.trim();
    }

    public String getFdContent() {
        return fdContent;
    }

    public void setFdContent(String fdContent) {
        this.fdContent = fdContent == null ? null : fdContent.trim();
    }
}