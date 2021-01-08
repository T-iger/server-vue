package com.my.servermvc.service.serviceImpl;

import com.my.common.result.Result;
import com.my.common.result.ResultFactory;
import com.my.common.utils.StringUtil;
import com.my.servermvc.dao.MenuDao;
import com.my.servermvc.entity.Menu;
import com.my.servermvc.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lh
 * @Date 2020/9/22
 * @Version: 1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 查询菜单list
     *
     * @return 菜单list
     */
    @Override
    public Result findMenuList() {
        List<Menu> menuList = menuDao.selectMenuList();
        List<Menu> m = new ArrayList<>();
        for (Menu menu : menuList) {
            List<Menu> child =new ArrayList<>();
            for (Menu menu1 : menuList) {
                if(menu1.getParentId()!= null && menu1.getParentId().equals(menu.getMenuId())){
                  child.add(menu1);
                }
            }
            if(child.size()!=0) {
                menu.setChildren(child);
            }
            if(menu.getParentId()==null) {
                m.add(menu);
            }
        }
        return ResultFactory.successResult(m);
    }
}
