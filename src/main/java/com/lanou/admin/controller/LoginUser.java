package com.lanou.admin.controller;

import com.lanou.admin.bean.SysUser;
import com.lanou.admin.service.LoginService;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.apache.activemq.leveldb.replicated.dto.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

/**
 * @author zar on 2017/11/9.
 */
@Controller
public class LoginUser {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String home() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "login";
    }

    // 用户登录表单验证
    @ResponseBody
    @RequestMapping(value = "/loginsubmit")
    public AjaxResult loginsubmit(HttpServletRequest request,
                                  @RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("rememberMe") boolean rememberMe,
                                  @RequestParam("verifyCode") String verifyCode) throws Exception {
        // shiro在认证过程中出现错误后,将异常类路径通过request返回
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        String code = (String) request.getSession().getAttribute("verifyCodeValue");
        long now = (long) request.getSession().getAttribute("now");
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTime().getTime();
        if (time - now > 30000) {
            return new AjaxResult(1, "验证码失效");
        }
        if (!code.equalsIgnoreCase(verifyCode)) {
            return new AjaxResult(1, "验证码输入错误");
        }
        try {
            SecurityUtils.getSubject().login(token);
            request.getSession().setAttribute("username", username);
            return new AjaxResult(0, "登录成功");
        } catch (UnknownAccountException uae) {
            return new AjaxResult(1, "用户名错误");
        } catch (IncorrectCredentialsException ice) {
            return new AjaxResult(1, "密码错误");
        }
    }

    @RequestMapping(value = "/getverifycode")
    public void generate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        String code = verifyCode.getText();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        VerifyCode.output(image, outputStream);
        request.getSession().setAttribute("verifyCodeValue", code);
        ServletOutputStream stream = response.getOutputStream();
        outputStream.writeTo(stream);
        Calendar calendar = Calendar.getInstance();
        request.getSession().setAttribute("now", calendar.getTime().getTime());
    }

    @ResponseBody
    @RequestMapping(value = "/getuser")
    public AjaxResult getUser(HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        return new AjaxResult(attribute, 0, null);
    }
}
