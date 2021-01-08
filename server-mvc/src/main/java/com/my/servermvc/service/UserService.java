package com.my.servermvc.service;

import com.my.common.result.Result;
import com.my.servermvc.entity.User;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/7
 * @Version: 1.0
 **/
public interface UserService {
    /**
     * 用户注册
     *
     * @param user 用户
     * @return 结果
     */
   Result register(User user);

    /**
     * 用户登录
     * @param user 用户，前端传过来的
     * @return 结果
     */
   Result userLogin(User user);

    /**
     * 检查用户登录名(唯一性)
     *
     * @param loginName 登录名
     * @return 检查结果
     */
   Result checkUserByLoginName(String loginName);

    /**
     * 查询用户list
     *
     *
     * @param query
     * @param pageNum 当前页数
     * @param pageSize 展示数
     * @return 用户list
     */
   Result findUserListByPage(String query, Integer pageNum, Integer pageSize);

    /**
     * 修改用户状态
     *
     * @param user 要修改的内容
     * @return 修改结果
     */
   Result updateUserStatus(User user);

    /**
     * 删除用户 (逻辑删除)
     *
     * @param userId 用户
     * @return 结果
     */
   Result deleteUser(String  userId);

    /**
     * 根据id查询
     *
     * @param userId id
     * @return 结果
     */
   Result findUserByUserId(String userId);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
   Result editUser(User user);
}
