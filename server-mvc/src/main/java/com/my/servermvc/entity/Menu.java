package com.my.servermvc.entity;

import java.util.List;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/14
 * @Version: 1.0
 **/
public class Menu {
    /**菜单id*/
    private String menuId;
    /**菜单名称*/
    private String menuName;
    /**菜单路径*/
    private String path;
    /**菜单id*/
    private String icon;
    /**菜单类型*/
    private Integer menuType;
    /**父菜单id*/
    private String parentId;
    /**子菜单*/
    private List<Menu> children;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
