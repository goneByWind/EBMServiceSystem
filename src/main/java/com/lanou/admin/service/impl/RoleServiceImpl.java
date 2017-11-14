package com.lanou.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysRole;
import com.lanou.admin.bean.SysUser;
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

    @Override
    public PageInfo<SysRole> showRoleListWithPage(Integer pageNo, Integer pageSize) {

        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?1:pageSize;

        PageHelper.startPage(pageNo,pageSize);

        List<SysRole> sysRoleList = sysRoleMapper.showRoleListWithPage();

        for (int i = 0; i < sysRoleList.size(); i++) {
            System.out.println(i);
            List<SysUser> sysUserList = sysRoleList.get(i).getSysUserList();
            for (SysUser sysUser : sysUserList) {
                System.out.println(sysUser.getUsername());
            }
        }
        // 通过测试,能够从数据库查到角色对应的具体管理员!

        PageInfo<SysRole> sysRolePageInfo = new PageInfo<SysRole>(sysRoleList);


        return sysRolePageInfo;
    }
}
