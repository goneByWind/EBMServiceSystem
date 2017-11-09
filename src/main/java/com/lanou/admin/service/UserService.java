package com.lanou.admin.service;

import com.lanou.admin.bean.SysUser;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface UserService {

    List<SysUser> findUserList();

    void updateUserById(SysUser sysUser);
}
