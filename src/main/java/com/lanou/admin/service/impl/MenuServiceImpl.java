package com.lanou.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysMenu;
import com.lanou.admin.mapper.SysMenuMapper;
import com.lanou.admin.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zar on 2017/11/9.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public PageInfo<SysMenu> findMenuPageInfo(Integer no, Integer size, String menuName) {
        System.out.println(no);
        System.out.println(size);
        System.out.println(menuName);
        return selectByInfo(no, size, menuName);
    }


    private PageInfo<SysMenu> selectByInfo(Integer pageNo, Integer pageSize, String menuName) {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<SysMenu> allMenu = sysMenuMapper.findAllMenu(menuName);
        System.out.println(allMenu);
        PageInfo<SysMenu> pageInfo = new PageInfo<SysMenu>(allMenu);
        return pageInfo;
    }
}
