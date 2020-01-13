package com.vas.blog.pojo;

import com.vas.sys.common.pojo.BasePojo;

import java.util.Date;

public class BlogMainCate extends BasePojo {
    private String fdName;

    private String fdParentId;

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName == null ? null : fdName.trim();
    }

    public String getFdParentId() {
        return fdParentId;
    }

    public void setFdParentId(String fdParentId) {
        this.fdParentId = fdParentId == null ? null : fdParentId.trim();
    }

}