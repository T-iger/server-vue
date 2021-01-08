package com.my.servermvc.dao;

import com.my.servermvc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 用户Dao
 * @Author: lh
 * @Date 2020/9/7
 * @Version: 1.0
 **/
@Mapper
public interface UserDao {

    /**
     * 增加用户
     * @param user  用户
     * @return 插入结果
     */
   Integer insertUser(User user);

   /**
     * 根据用户名查询
     * @param loginName  登录名
     * @return 结果
     */
   User selectUserByLoginName(String loginName);

    /**
     * 根据分页查询用户list
     *
     * @param query 查询的信息
     * @param pageNum 当前页数
     * @param pageSize 展示数
     * @return 用户list
     */
   List<User> selectUserListByPage(String query, Integer pageNum, Integer pageSize);

    /**
     * 统计user
     *
     * @return user数
     */
   Integer countUser();

    /**
     * 修改用户状态
     *
     * @param user 用户
     * @return 修改结果
     */
   Integer updateUserStatus(User user);

    /**
     * 删除用户(逻辑删除)
     *
     * @param userId 用户
     * @return 删除结果
     */
   Integer updateUserDelFlag(String userId);

    /**
     * 根据用户id查询
     *
     * @param userId id
     * @return 用户
     */
   User selectUserById(String userId);

    /**
     * 修改用户信息
     *
     * @param user 用户(针对 姓名 、密码、登录ip、登录时间修改)
     * @return 结果
     */
   Integer updateUser(User user);

    /**
     * 删除角色，用户为此角色时，把用户角色置为 无角色(id=0)
     *
     * @param roleId 角色id
     * @return 结果
     */
   Integer deleteUserRole(String roleId);

}
