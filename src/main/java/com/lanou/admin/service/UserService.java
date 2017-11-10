package com.lanou.admin.service;

import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysUser;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface UserService {

    List<SysUser> findUserList();

    void updateUserById(SysUser sysUser);

    void addUser(SysUser sysUser);

    void deleteUserById(Integer userId);

    SysUser findUserById(Integer userIdInSession);

    PageInfo<SysUser> searchWithConditionForUser(String startData, String endData, String userName, Integer pageNo, Integer pageSize) throws ParseException;
}
