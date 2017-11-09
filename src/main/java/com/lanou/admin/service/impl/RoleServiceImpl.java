package com.lanou.admin.service.impl;

import com.lanou.admin.bean.SysRole;
import com.lanou.admin.mapper.SysRoleMapper;
import com.lanou.admin.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;


    @Override
    public List<SysRole> findRoleList() {
        return sysRoleMapper.findRoleList();
    }
}
