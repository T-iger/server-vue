package com.my.servermvc.dao;

import com.my.servermvc.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 菜单dao
 * @Author: lh
 * @Date 2020/9/22
 * @Version: 1.0
 **/
@Mapper
public interface MenuDao {

    /**
     * 查询菜单
     *
     * @return 菜单list
     */
   List<Menu> selectMenuList();
}
