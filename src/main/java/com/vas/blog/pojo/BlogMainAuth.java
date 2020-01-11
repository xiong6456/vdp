package com.vas.blog.pojo;

public class BlogMainAuth {
    private String fdUserId;

    private String fdDocId;

    public String getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(String fdUserId) {
        this.fdUserId = fdUserId == null ? null : fdUserId.trim();
    }

    public String getFdDocId() {
        return fdDocId;
    }

    public void setFdDocId(String fdDocId) {
        this.fdDocId = fdDocId == null ? null : fdDocId.trim();
    }
}