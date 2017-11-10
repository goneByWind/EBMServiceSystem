package com.lanou.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysUser;
import com.lanou.admin.service.UserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
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
    @RequestMapping(value = "/userEditPassword")
    public String userModi(){
        return "admin-password-edit";
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

    @ResponseBody
    @RequestMapping("/addUser")
    public AjaxResult addUser(SysUser sysUser){
        sysUser.setCreateTime(new Date());
        sysUser.setState(1);
        userService.addUser(sysUser);
        return new AjaxResult("添加新管理员成功");
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public AjaxResult deleteUser(@RequestParam("id") Integer userId){
        userService.deleteUserById(userId);
        return new AjaxResult("删除用户成功!");
    }

    @ResponseBody
    @RequestMapping("/saveUserIdInSession")
    public void saveUserIdInSession(HttpServletRequest request,@RequestParam("userId")Integer userId){
        request.getSession().setAttribute("userIdInSession",userId);
    }

    @ResponseBody
    @RequestMapping("/getUserIdInSession")
    public AjaxResult getUserIdInSession(HttpServletRequest request){
        Integer userIdInSession = (Integer) request.getSession().getAttribute("userIdInSession");
        SysUser userById = userService.findUserById(userIdInSession);
        String password = userById.getPassword();
        return new AjaxResult(password,0,"通过session中的userId查找出密码");
    }
    @ResponseBody
    @RequestMapping("/modiPassword")
    public AjaxResult modiPassword(HttpServletRequest request,@RequestParam("newPassword")String password){
        Integer userIdInSession = (Integer) request.getSession().getAttribute("userIdInSession");
        SysUser userById = userService.findUserById(userIdInSession);
        userById.setPassword(password);
        userService.updateUserById(userById);
        return new AjaxResult("修改该管理员密码成功!");
    }

    @ResponseBody
    @RequestMapping("/vastDeleteUser")
    public AjaxResult vastDeleteUser(@RequestParam(value = "userIdList",required = false) Integer[] userIdList){
        for (Integer uId : userIdList) {
            System.out.println("选择将要删除的user条目的Id:"+uId);
            userService.deleteUserById(uId);
        }
        return new AjaxResult("完成利用checkbox批量删除");
    }

    @ResponseBody
    @RequestMapping("/searchWithConditionForUser")
    public AjaxResult searchWithConditionForUser(@RequestParam(value = "startData",required = false) String startData,
                                                 @RequestParam(value = "endData",required = false) String endData,
                                                 @RequestParam(value = "userName",required = false) String userName,
                                                 @RequestParam(value = "no",required=false) Integer pageNo,
                                                 @RequestParam(value = "size",required=false) Integer pageSize) throws ParseException {
        System.out.println(startData);
        System.out.println(endData);
        PageInfo<SysUser> sysUserPageInfo = userService.searchWithConditionForUser(startData, endData, userName, pageNo, pageSize);
        return new AjaxResult(sysUserPageInfo,0,"模糊查询&分页后的数据");
    }
}
