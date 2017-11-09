package com.lanou.admin.controller;

import com.lanou.admin.bean.SysRole;
import com.lanou.admin.service.RoleService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/showRoleList")
    public AjaxResult showRoleList(){
        List<SysRole> roleList = roleService.findRoleList();
        System.out.println(roleList);
        return new AjaxResult(roleList,0,"返回角色列表");
    }
}
