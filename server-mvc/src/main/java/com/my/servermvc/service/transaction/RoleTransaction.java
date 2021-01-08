package com.my.servermvc.service.transaction;

import com.my.common.result.Result;
import com.my.servermvc.dao.RoleDao;
import com.my.servermvc.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/23
 * @Version: 1.0
 **/
@Service
public class RoleTransaction {
    @Resource
    private RoleDao roleDao;
    @Resource
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = {Exception.class})
    public void deleteRoleAndRelated(String roleId){
        if (roleId.equals("0")){
            throw new RuntimeException("权限不足");
        }
        Integer integer=0;
        integer = roleDao.deleteRoleById(roleId);
        if (integer==0) {
            throw new RuntimeException("删除角色失败");
        }
        userDao.deleteUserRole(roleId);
    }
}
