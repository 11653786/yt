package com.yt.mybatis.entity;

import java.util.Date;

/**
 * @author zhangsan
 * @class Auth 权限
 * @version 1.0 
 * @date 2016/3/28 0028 15:01
 * @descption: 疯狂的王麻子团队!
 */
public class Auth {
    private Integer id;

    private String authName;
    /**
     * 权限类型:权限类型,1.按钮,2页面,3菜单
     */
    private String authType;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 是否可用
     */
    private String isEnable;
    /**
     * 权限url
     */
    private String authUrl;

    private Integer createUser;

    private Date createDate;

    private Integer updateUser;

    private Date updateTime;

    private String authDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }
    public String getAuthType() {
        return authType;
    }


    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl == null ? null : authUrl.trim();
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

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc == null ? null : authDesc.trim();
    }
}