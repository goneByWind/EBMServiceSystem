package com.lanou.admin.mapper;

import com.lanou.admin.bean.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    SysUser selectByUserName(@Param("username") String username);

    List<SysUser> findUserList();
}