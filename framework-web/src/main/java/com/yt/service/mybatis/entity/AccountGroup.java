package com.yt.service.mybatis.entity;

import java.util.Date;

public class AccountGroup {
    private Integer id;

    private String accountGroupName;

    private String isEnable;

    private Integer createUser;

    private Date craeteTime;

    private Integer updateUser;

    private Date updateTime;

    private String accountGroupDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(String accountGroupName) {
        this.accountGroupName = accountGroupName == null ? null : accountGroupName.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccountGroupDesc() {
        return accountGroupDesc;
    }

    public void setAccountGroupDesc(String accountGroupDesc) {
        this.accountGroupDesc = accountGroupDesc == null ? null : accountGroupDesc.trim();
    }
}