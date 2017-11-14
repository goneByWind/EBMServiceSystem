package com.lanou.admin.mapper;

import com.lanou.admin.bean.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 精确查找节点
     *
     * @return 菜单集合
     */
    List<SysMenu> findAllMenu(@Param("menuName") String menuName);

    List<SysMenu> findByRoleId(@Param("id") Integer id);
}