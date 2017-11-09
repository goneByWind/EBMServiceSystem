package com.lanou.admin.service.impl;

import com.lanou.admin.bean.SysUser;
import com.lanou.admin.mapper.SysUserMapper;
import com.lanou.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUserList() {

        List<SysUser> userList = sysUserMapper.findUserList();

        return userList;
    }

    @Override
    public void updateUserById(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
