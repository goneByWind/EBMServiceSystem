package com.lanou.admin.controller;

import com.lanou.admin.bean.SysUser;
import com.lanou.admin.service.UserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userlist")
    public String userList(){
        return "admin-list";
    }
    @RequestMapping(value = "/userAdd")
    public String userAdd(){
        return "admin-add";
    }
    @ResponseBody
    @RequestMapping("/findSysUser")
    public AjaxResult findSysUser(){
        List<SysUser> userList = userService.findUserList();
        return new AjaxResult(userList,0,"返回全部管理员条目");
    }

    @ResponseBody
    @RequestMapping("/stopUser")
    public AjaxResult stopUser(SysUser sysUser){
        userService.updateUserById(sysUser);
        return new AjaxResult("修改用户状态为:已停用");
    }

    @ResponseBody
    @RequestMapping("/startUser")
    public AjaxResult startUser(SysUser sysUser){
        userService.updateUserById(sysUser);
        return new AjaxResult("修改用户状态为:已启用");
    }
}
