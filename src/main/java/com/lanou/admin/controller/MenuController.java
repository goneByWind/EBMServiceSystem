package com.lanou.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysMenu;
import com.lanou.admin.service.MenuService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zar on 2017/11/9.
 */
@Controller
public class MenuController {
    @Resource
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/allpageinfo", method = RequestMethod.POST)
    public AjaxResult allPageInfo(@RequestParam("no") Integer no,
                                  @RequestParam("size") Integer size,
                                  @RequestParam("menuName") String menuName) {
        if (menuName == null || menuName.trim().isEmpty()) {
            menuName = null;
        }
        PageInfo<SysMenu> menuPageInfo = menuService.findMenuPageInfo(no, size, menuName);
        System.out.println(menuPageInfo);
        return new AjaxResult(menuPageInfo, 0, null);
    }
}
