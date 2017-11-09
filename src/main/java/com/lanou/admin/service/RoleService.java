package com.lanou.admin.service;

import com.lanou.admin.bean.SysRole;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface RoleService {
    List<SysRole> findRoleList();
}
