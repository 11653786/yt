package com.yt.mybatis.entity;

import com.yt.util.yt.annotation.Table;

import java.util.Date;

@Table(name = "日志")
public class Log {
    private Integer id;

    private String className;

    private Integer createUser;

    private Date createDate;

    private Integer isSuccess;

    private Integer spendTime;

    /**
     * 操作
     */
    private String actions;

    private byte[] logInfo;

    /**
     * 实体类名称
     */
    private String entityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public byte[] getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(byte[] logInfo) {
        this.logInfo = logInfo;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}