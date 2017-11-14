package com.lanou.admin.service.impl;

import com.lanou.admin.bean.SysUser;
import com.lanou.admin.mapper.SysUserMapper;
import com.lanou.admin.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zar on 2017/11/9.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(String username) {
        return sysUserMapper.selectByUserName(username);
    }
}
