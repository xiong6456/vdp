package com.vas.sys.common.pojo;

public class Page {
    /**数据库查询起始数量*/
    private Integer startNum;
    /**数据库查询结束数量*/
    private Integer endNum;
    /**前台传过来的页码数*/
    private String curPage;
    /**前台传过来的每页显示多少条*/
    private String pageSize;

    public Integer getStartNum() {
        startNum = (Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize)+1;
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEndNum() {
        endNum = Integer.parseInt(curPage)*Integer.parseInt(pageSize);
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
