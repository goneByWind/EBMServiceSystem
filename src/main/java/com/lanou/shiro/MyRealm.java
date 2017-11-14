package com.lanou.shiro;

import com.lanou.admin.bean.SysUser;
import com.lanou.admin.mapper.SysUserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public class MyRealm extends AuthorizingRealm {

    @Lazy
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public String getName() {
        return "ZarAndLxx";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    // 验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysUserMapper.selectByUserName(username);
        if (sysUser == null) {
            throw new UnknownAccountException("用户名不对");
        }

        String password = new String((char[]) authenticationToken.getCredentials());
        if (!(sysUser.getPassword().equals(password))) {
            throw new IncorrectCredentialsException("密码不对");
        }

        return new SimpleAuthenticationInfo(sysUser, password, getName());
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*这个是上面认证时,放在return中的user,好方便*/
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        // 可以获取user的用户id及各种信息↑
        SysUser byUserId = sysUserMapper.findByUserId(sysUser.getId());
        System.out.println(byUserId);
        System.out.println(sysUser);
        // TODO: 2017/11/9 授权!!! 
        List<String> perList = Arrays.asList("user:query", "user:update");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        for (String per : perList) {
            info.addStringPermission(per);
        }

        return null;
    }
}
