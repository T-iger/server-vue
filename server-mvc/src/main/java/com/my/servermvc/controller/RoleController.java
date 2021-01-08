package com.my.servermvc.controller;

import com.my.common.result.Result;
import com.my.common.result.ResultFactory;
import com.my.servermvc.constant.Constant;
import com.my.servermvc.entity.Role;
import com.my.servermvc.entity.User;
import com.my.servermvc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 角色controller
 * @Author: lh
 * @Date 2020/9/21
 * @Version: 1.0
 **/
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "findRole", method = RequestMethod.GET)
    @ResponseBody
    public Result findRole(){
        return roleService.roleList();
    }


    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    @ResponseBody
    public Result getRoleList(@RequestParam(name = "query",required = false)String query,
                           @RequestParam(name = "pageNum")Integer pageNum,
                           @RequestParam(name = "pageSize")Integer pageSize){
        return roleService.getRoleList(query,pageNum, pageSize);
    }

    @RequestMapping(value = "deleteRole", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteRole(@RequestParam(name = "roleId")String roleId){
        if (roleId.equals(Constant.SUPER_ROLE_ID)){
            return ResultFactory.failResult("权限不足");
        }
        return  roleService.deleteRole(roleId);
    }

    @RequestMapping(value = "addRole", method = RequestMethod.GET)
    @ResponseBody
    public Result addRole(@RequestParam(name = "roleName")String roleName){
        Role role = new Role();
        role.setRoleName(roleName);
        User user =new User();
        user.setUserId("1");
        role.setCreateUser(user);
        return  roleService.addRole(role);
    }

}
