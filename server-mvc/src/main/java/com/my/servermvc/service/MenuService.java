package com.my.servermvc.service;

import com.my.common.result.Result;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/22
 * @Version: 1.0
 **/
public interface MenuService {
    /**
     * 查询菜单list
     *
     * @return 菜单list
     */
    Result findMenuList();
}
