package com.my.servermvc.entity;

import java.util.Date;

/**
 * @Description: 用户角色
 * @Author: lh
 * @Date 2020/9/21
 * @Version: 1.0
 **/
public class Role {
    /**角色id*/
    private String roleName;
    /**角色name*/
    private String roleId;
    /**角色创建者*/
    private User createUser;
    /**创建时间*/
    private Date createTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
