package com.vas.sys.common.pojo;

import com.vas.util.IDGenerator;
import com.vas.util.UserUtil;

import java.io.Serializable;
import java.util.Date;

public abstract class BasePojo implements IBasePojo, Serializable{
    protected String fdId;
    public String getFdId() {
        if (fdId == null) {
            fdId = IDGenerator.generateID();
        }
        return fdId;
    }
    public void setFdId(String id) {
        this.fdId = id;
    }

    protected Long docOrder;
    public Long getDocOrder(){
        if (docOrder == null) {
            docOrder = System.currentTimeMillis();
        }
        return docOrder;
    }
    public void setDocOrder(Long docOrder){
        this.docOrder = docOrder;
    }

    protected String docCreatorId;
    public String getDocCreatorId(){
        if (docCreatorId == null) {
            docCreatorId = UserUtil.getUser().getFdId();
        }
        return docCreatorId;
    }
    public void setDocCreatorId(String docCreatorId){
        this.docCreatorId = docCreatorId;
    }

    protected String docAlterorId;
    public String getDocAlterorId(){
        if (docAlterorId == null) {
            docAlterorId = UserUtil.getUser().getFdId();
        }
        return docAlterorId;
    }
    public void setDocAlterorId(String docAlterorId){
        this.docAlterorId = docAlterorId;
    }

    protected Date docCreateTime;
    public Date getDocCreateTime(){
        if (docCreateTime == null) {
            docCreateTime = new Date();
        }
        return docCreateTime;
    }
    public void setDocCreateTime(Date docCreateTime){
        this.docCreateTime = docCreateTime;
    }

    protected Date docAlterTime;
    public Date getDocAlterTime(){
        if (docAlterTime == null) {
            docAlterTime = new Date();
        }
        return docAlterTime;
    }

    public void setDocAlterTime(Date docAlterTime){
        this.docAlterTime = docAlterTime;
    }
}
