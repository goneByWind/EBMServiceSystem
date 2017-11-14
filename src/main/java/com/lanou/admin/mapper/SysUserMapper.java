package com.lanou.admin.mapper;

import com.lanou.admin.bean.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    /**
     * @param startData 查询:起始创建时间
     * @param endData   查询:结束创建时间
     * @param userName  用户名(可模糊)
     * @return
     */
    List<SysUser> searchWithConditionForUser(@Param("startData") String startData,
                                             @Param("endData") String endData,
                                             @Param("userName") String userName);

    List<SysUser> findUserListByRoleId(@Param("roleId") Integer roleId);

    /**
     * 通过id查询user
     *
     * @param userId 用户id
     * @return 用户对象
     */
    SysUser findByUserId(@Param("userId") Integer userId);
}