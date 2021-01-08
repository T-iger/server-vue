package com.my.servermvc.controller;

import com.my.common.result.Result;
import com.my.common.result.ResultFactory;
import com.my.servermvc.constant.Constant;
import com.my.servermvc.entity.Menu;
import com.my.servermvc.entity.User;
import com.my.servermvc.security.jwt.TokenService;
import com.my.servermvc.service.MenuService;
import com.my.servermvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 登录controller
 * @Author: lh
 * @Date 2020/9/5
 * @Version: 1.0
 **/
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    TokenService tokenService;

    /**
     * 用户登录
     *
     * @param user 前端传递过来的登录信息
     * @return 登录结果
     */
    @RequestMapping(value="login", method=RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user, HttpServletRequest request) {
        String host = request.getLocalAddr();
        user.setLastLoginIp(host);
        return userService.userLogin(user);
    }

    /**
     * 用户注册
     *
     * @param user 前端传递过来的注册信息
     * @return 注册结果
     */
    @RequestMapping(value="register", method=RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 检查用户名唯一性
     *
     * @param loginName 前端传递过来的登录名
     * @return 结果
     */
    @RequestMapping(value="checkUser", method=RequestMethod.GET)
    @ResponseBody
    public Result checkUser(@RequestParam(name = "loginName",required = false)String loginName){
        return userService.checkUserByLoginName(loginName);
    }

    /**
     * 获取菜单
     *
     * @return 菜单list
     */
    @RequestMapping(value = "menuList",method = RequestMethod.GET)
    @ResponseBody
    public Result getMenuList(){
        List<Menu> menuList=new ArrayList<>();
        Menu menu = new Menu();
        menu.setMenuId("1");
        menu.setMenuName("首页");
        menu.setIcon("el-icon-s-home");

        List<Menu> child=new ArrayList<>();
        Menu c = new Menu();
        c.setMenuId("设置");
        c.setMenuName("设置");
        c.setPath("user");
        child.add(c);

        Menu menu1 = new Menu();
        menu1.setMenuId("2");
        menu1.setMenuName("用户管理");
        menu1.setIcon("el-icon-user-solid");
        menu1.setChildren(child);

        Menu menu2 = new Menu();
        menu2.setMenuId("3");
        menu2.setMenuName("角色管理");
        menu2.setIcon("el-icon-user-solid");
        menu2.setChildren(child);

        menuList.add(menu);
        menuList.add(menu1);
        menuList.add(menu2);
        Result menuList1 = menuService.findMenuList();

        return menuList1;
    }

    /**
     * 获取用户list
     *
     * @return 用户list
     */
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserList (@RequestParam(name = "query",required = false)String query,
                               @RequestParam(name = "pageNum")Integer pageNum,
                               @RequestParam(name = "pageSize")Integer pageSize) {
        return userService.findUserListByPage(query,pageNum, pageSize);
    }

    /**
     * 修改用户状态
     *
     * @param user 被修改的user
     * @return 返回修改结果
     */
    @RequestMapping(value = "changeUserStatus", method = RequestMethod.POST)
    @ResponseBody
    public Result changeUserStatus(@RequestBody User user){
        if (user.getUserId()==null){
            return ResultFactory.failResult("账号异常");
        }
        if(user.getUserId().equals(Constant.SUPER_USER_ID)){
            return ResultFactory.failResult("权限不足");
        }
        return userService.updateUserStatus(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 删除结果
     */
    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteUser(@RequestParam(name = "id")String id){
        if(id.equals(Constant.SUPER_USER_ID)){
            return ResultFactory.failResult("权限不足");
        }
        return userService.deleteUser(id);
    }

    /**
     * 查询用户根据id
     *
     * @param userId 用户ID
     * @return 查询结果
     */
    @RequestMapping(value = "findUser",method = RequestMethod.GET)
    @ResponseBody
    public Result findUser(@RequestParam(name = "id")String userId){

        return userService.findUserByUserId(userId);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户
     * @return 查询结果
     */
    @RequestMapping(value = "editUser",method = RequestMethod.POST)
    @ResponseBody
    public Result editUser(@RequestBody User user){
        if(user.getUserId().equals(Constant.SUPER_USER_ID)){
            return ResultFactory.failResult("权限不足");
        }
        return userService.editUser(user);
    }
}
