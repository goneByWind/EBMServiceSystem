package com.lanou.admin.controller;

import com.lanou.exception.CustomerException;
import com.lanou.utils.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zar on 2017/11/9.
 */
@Controller
public class LoginUser {
    @RequestMapping(value = "/login")
    public String home() {
        return "login";
    }

    // 用户登录表单验证
    @ResponseBody
    @RequestMapping(value = "/loginsubmit")
    public AjaxResult loginsubmit(HttpServletRequest request,
                                  @RequestParam("username") String username,
                                  @RequestParam("password") String password) throws Exception {
        // shiro在认证过程中出现错误后,将异常类路径通过request返回
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            return new AjaxResult(0, "登录成功");
        } catch (UnknownAccountException uae) {
            return new AjaxResult(1, "用户名错误");
        } catch (IncorrectCredentialsException ice) {
            return new AjaxResult(1, "密码错误");
        }
    }
}
