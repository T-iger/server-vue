package com.my.servermvc.service.serviceImpl;

import com.my.common.result.Result;
import com.my.common.result.ResultFactory;
import com.my.common.utils.DBKeyUtil;
import com.my.common.utils.StringUtil;
import com.my.servermvc.dao.RoleDao;
import com.my.servermvc.entity.Role;
import com.my.servermvc.service.RoleService;
import com.my.servermvc.service.transaction.RoleTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/21
 * @Version: 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private  RoleDao roleDao;
    @Resource
    private RoleTransaction roleTransaction;

    /**
     * 查找角色list 分页
     *
     * @return 角色list
     */
    @Override
    public Result getRoleList(String query, Integer pageNum, Integer pageSize) {
        HashMap<String,Object> map=new HashMap<>();
        List<Role> roles = roleDao.selectRoleList(query,(pageNum - 1) * pageSize,pageSize);
        Integer total = roleDao.countRole();
        map.put("roleList",roles);
        if(StringUtil.isEmpty(query)){
            map.put("total",total);
        } else {
            map.put("total",roles.size());
        }
        return ResultFactory.successResult(map);
    }

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return 删除结果
     */
    @Override
    public Result deleteRole(String roleId) {
        try {
            roleTransaction.deleteRoleAndRelated(roleId);
            return ResultFactory.successResult("删除成功",null);
        }catch (RuntimeException e){
            return ResultFactory.failResult(e.getMessage());
        }
    }

    /**
     * 增加角色
     *
     * @param role 角色
     * @return null
     */
    @Override
    public Result addRole(Role role) {
        role.setRoleId(DBKeyUtil.getDBKey("xx"));
        role.setCreateTime(new Date());
        Integer integer = roleDao.addRole(role);
        if (integer == 0 ){
            return ResultFactory.failResult("增加失败");
        }
        return ResultFactory.successResult("增加成功" ,null);
    }

    /**
     * 查询角色list
     *
     * @return 角色list 无分页
     */
    @Override
    public Result roleList() {
        return ResultFactory.successResult(roleDao.selectRole());
    }
}
