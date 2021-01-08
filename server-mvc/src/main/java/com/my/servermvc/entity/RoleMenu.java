package com.my.servermvc.entity;

import java.util.Date;

/**
 * @Description: 角色菜单表
 * @Author: lh
 * @Date 2020/9/24
 * @Version: 1.0
 **/
public class RoleMenu {
    /**主键 id*/
    private String id;
    /**角色id*/
    private String roleId;
    /**菜单id*/
    private String menuId;
    /**删除标识*/
    private Integer delFlag;
    /**创建时间*/
    private Date createTime;

}
