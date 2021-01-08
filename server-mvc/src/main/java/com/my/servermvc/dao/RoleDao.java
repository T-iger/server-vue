package com.my.servermvc.dao;

import com.my.servermvc.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 用户Dao
 * @Author: lh
 * @Date 2020/9/21
 * @Version: 1.0
 **/
@Mapper
public interface RoleDao {

    /**
     * 查询用户list
     *
     * @param query 内容
     * @param pageNum 页数
     * @param pageSize 大小
     * @return 角色list
     */
    List<Role> selectRoleList(String query, Integer pageNum, Integer pageSize);

    /**
     * 统计角色
     *
     * @return 角色数
     */
    Integer countRole();

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return 删除结果
     */
    Integer deleteRoleById(String roleId);

    /**
     * 增加角色
     *
     * @param role 角色
     * @return 结果
     */
    Integer addRole(Role role);

    /**
     * 只查询角色
     *
     * @return 角色list
     */
   List<Role> selectRole();
}
