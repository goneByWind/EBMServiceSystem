package com.lanou.admin.mapper;

import com.lanou.admin.bean.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 更改了mappper
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> findRoleList();

    List<SysRole> showRoleListWithPage();

    /**
     * 级联查找角色
     *
     * @param roleId 角色id
     * @return 角色
     */
    SysRole findByRoleId(@Param("roleId") Integer roleId);
}