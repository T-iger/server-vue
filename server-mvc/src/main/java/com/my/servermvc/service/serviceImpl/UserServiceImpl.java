package com.my.servermvc.service.serviceImpl;

import com.my.common.result.Result;
import com.my.common.result.ResultFactory;
import com.my.common.utils.DBKeyUtil;
import com.my.common.utils.StringUtil;
import com.my.servermvc.constant.Constant;
import com.my.servermvc.dao.RoleDao;
import com.my.servermvc.dao.UserDao;
import com.my.servermvc.entity.User;


import com.my.servermvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/7
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);


    /**
     * 注册
     *
     * @param user 用户
     * @return 注册结果
     */
    @Override
    public Result register(User user) {
        Integer integer=0;
        try {
            user.setUserId(DBKeyUtil.getDBKey("sm"));
            user.setStatus(1);
            user.setCreateTime(new Date());
            integer = userDao.insertUser(user);
            if(integer!=0){
                logger.info("新增用户，成功");
                return ResultFactory.successResult("注册成功","注册成功");
            } else {
                return ResultFactory.failResult("注册失败");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
            return ResultFactory.successResult("注册失败,操作数据库异常","注册失败");
        }
    }

    /**
     * 用户登录
     *
     * @param user 用户，前端传过来的
     * @return 登录结果
     */
    @Override
    public Result userLogin(User user) {
        User u = userDao.selectUserByLoginName(user.getLoginName());
        //登录名不存在
        if (StringUtil.isEmpty(u)) {
            return ResultFactory.failResult("无效登录名");
        }
        //密码错误
        if (!u.getPassword().equals(user.getPassword())) {
            return ResultFactory.failResult("密码错误");
        }
        // 修改登录信息
        u.setLastLoginTime(new Date());
        u.setLastLoginIp(user.getLastLoginIp());
        userDao.updateUser(u);

        //检查用户状态
        if (Constant.USER_STATUS_LOCK.equals(u.getStatus())) {
            return ResultFactory.failResult("当前用户锁定");
        }
        //增token
        Map<String,String> map=new HashMap<>();
        map.put("token","111");
        return ResultFactory.successResult("登录成功",map);
    }

    /**
     * 检查用户登录名(唯一性)
     *
     * @param loginName 登录名
     * @return 检查结果
     */
    @Override
    public Result checkUserByLoginName(String loginName) {
        User user = userDao.selectUserByLoginName(loginName);
        if(StringUtil.isEmpty(user)){
            return ResultFactory.successResult("登录名可以使用",null);
        }else{
            return ResultFactory.failResult("登录名已存在");
        }
    }

    /**
     * 查询用户list
     *
     * @param query 模糊查询内容
     * @param pageNum  当前页数
     * @param pageSize 展示数
     * @return 用户list
     */
    @Override
    public Result findUserListByPage(String query, Integer pageNum, Integer pageSize) {
        HashMap<String,Object> map=new HashMap<>();
        List<User> users = userDao.selectUserListByPage(query,(pageNum - 1) * pageSize, pageSize);
        Integer total = userDao.countUser();
        map.put("userList",users);
        if(StringUtil.isEmpty(query)){
            map.put("total",total);
        } else {
            map.put("total",users.size());
        }
        return ResultFactory.successResult(map);
    }

    /**
     * 修改用户状态
     *
     * @param user 要修改的内容
     * @return 修改结果
     */
    @Override
    public Result updateUserStatus(User user) {
        Integer integer = userDao.updateUserStatus(user);
        if (integer==0){
            return ResultFactory.failResult("操作数据库异常");
        }
        return ResultFactory.successResult("用户状态设置成功","用户状态设置成功");
    }

    /**
     * 删除用户 (逻辑删除)
     *
     * @param userId 用户
     * @return 结果
     */
    @Override
    public Result deleteUser(String  userId) {
        Integer integer=0;
        integer = userDao.updateUserDelFlag(userId);
        if (integer!=0){
            return ResultFactory.successResult("删除成功");
        } else {
            return ResultFactory.failResult("删除失败");
        }
    }

    /**
     * 根据id查询
     *
     * @param userId id
     * @return 结果
     */
    @Override
    public Result findUserByUserId(String userId) {
        User user = userDao.selectUserById(userId);
        if (StringUtil.isNotEmpty(user)){
            return ResultFactory.successResult(user);
        }else{
            return ResultFactory.failResult("账号异常");
        }
    }

    /**
     * 修改用户
     *
     * @param user 用户(针对 姓名 、密码、登录ip、登录时间修改)
     * @return 结果
     */
    @Override
    public Result editUser(User user) {
        Integer integer = 0;
        integer = userDao.updateUser(user);
        if (integer != 0){
            return ResultFactory.successResult("修改信息成功");
        } else {
            return ResultFactory.successResult("修改信息成功");
        }
    }
}
