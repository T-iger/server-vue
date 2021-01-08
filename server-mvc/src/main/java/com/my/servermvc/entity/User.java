package com.my.servermvc.entity;

import java.util.Date;

/**
 * @Description: 用户表
 * @Author: lh
 * @Date 2020/9/5
 * @Version: 1.0
 **/
public class User {

    /**用户id*/
    private String userId;
    /**用户姓名*/
    private String userName;
    /**用户登录名*/
    private String loginName;
    /**用户密码*/
    private String password;
    /**用户年龄*/
    private Integer age;
    /**用户性别*/
    private String sex;
    /**用户账号状态 正常：1 锁定:2 */
    private Integer status;
    /**删除表示 正常：1 删除:0 */
    private Integer delFlag;
    /** 锁定时间 */
    private String lockTime;
    /** 最后一次登录时间 */
    private Date lastLoginTime;
    /** 最后一次登录IP */
    private String lastLoginIp;
    /** 创建时间 */
    private Date createTime;
    /** 角色 */
    private Role role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getLockTime() {
        return lockTime;
    }

    public void setLockTime(String lockTime) {
        this.lockTime = lockTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
