package com.vas.sys.common.pojo;

import java.util.Date;

public interface IBasePojo {
    /**
     * @return ID
     */
    public abstract String getFdId();
    /**
     * 设置ID
     *
     * @param id
     */
    public abstract void setFdId(String id);

    /**
     * @return docOrder
     */
    public abstract Long getDocOrder();
    /**
     * 设置排序
     *
     * @param docOrder
     */
    public abstract void setDocOrder(Long docOrder);

    /**
     * @return docCreatorId
     */
    public abstract String getDocCreatorId();
    /**
     * 设置创建者
     *
     * @param docCreatorId
     */
    public abstract void setDocCreatorId(String docCreatorId);

    /**
     * @return docAlterorId
     */
    public abstract String getDocAlterorId();
    /**
     * 设置修改者
     *
     * @param docAlterorId
     */
    public abstract void setDocAlterorId(String docAlterorId);

    /**
     * @return docCreateTime
     */
    public abstract Date getDocCreateTime();
    /**
     * 设置创建时间
     *
     * @param docCreateTime
     */
    public abstract void setDocCreateTime(Date docCreateTime);

    /**
     * @return docAlterTime
     */
    public abstract Date getDocAlterTime();
    /**
     * 设置修改时间
     *
     * @param docAlterTime
     */
    public abstract void setDocAlterTime(Date docAlterTime);
}
