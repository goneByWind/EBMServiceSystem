package com.lanou.admin.controller;

import com.lanou.exception.CustomerException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping(value = "/loginsubmit")
    public String loginsubmit(HttpServletRequest request) throws Exception {
        // shiro在认证过程中出现错误后,将异常类路径通过request返回
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (exceptionClassName.equals(UnknownAccountException.class.getName())) {
            throw new CustomerException("账户名不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            throw new CustomerException("密码错误");
        } else {
            throw new Exception();
        }
    }
}
