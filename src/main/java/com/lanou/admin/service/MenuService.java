package com.lanou.admin.service;

import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysMenu;

import java.util.List;

/**
 * @author zar on 2017/11/9.
 */
public interface MenuService {
    /**
     * 查找分页信息
     *
     * @param no       第几页
     * @param size     每页几条
     * @param menuName 查找的名字
     * @return 菜单分页集合
     */
    PageInfo<SysMenu> findMenuPageInfo(Integer no, Integer size, String menuName);
}
