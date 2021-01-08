package com.my.servermvc.vo;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/7
 * @Version: 1.0
 **/
public class UserVo {
    /**用户姓名*/
    private String userName;
    /**用户登录名*/
    private String loginName;
    /**用户密码*/
    private String password;

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
}
