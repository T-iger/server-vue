package com.my.servermvc.service;

import com.my.common.result.Result;
import com.my.servermvc.entity.Role;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/21
 * @Version: 1.0
 **/
public interface RoleService {
    /**
     * 查找角色list
     *
     * @param query 内容
     * @param pageNum 页数
     * @param pageSize 大小
     * @return 角色list
     */
    Result getRoleList(String query, Integer pageNum, Integer pageSize);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return 删除结果
     */
    Result deleteRole(String roleId);

    /**
     * 增加角色
     *
     * @param role 角色
     * @return null
     */
    Result addRole(Role role);

    /**
     * 查询角色list
     *
     * @return 角色list 无分页
     */
    Result roleList();

}
