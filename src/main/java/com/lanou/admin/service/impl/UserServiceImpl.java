package com.lanou.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.admin.bean.SysUser;
import com.lanou.admin.mapper.SysUserMapper;
import com.lanou.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public void addUser(SysUser sysUser) {
        sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public void deleteUserById(Integer userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser findUserById(Integer userIdInSession) {
        return sysUserMapper.selectByPrimaryKey(userIdInSession);
    }


    @Override
    public PageInfo<SysUser> searchWithConditionForUser(String startData, String endData, String userName, Integer pageNo, Integer pageSize) throws ParseException {

        // 设置默认的起始/结束时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//使输出的格式为YYYY-MM-dd
        Date EarliestStartDate = sdf.parse("2000-01-01");
        Date LastEndDate = new Date();

        String startData1 = sdf.format(EarliestStartDate);
        String endData1 = sdf.format(LastEndDate);


        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;

        startData = startData.equals("")?startData1:startData;
        endData = endData.equals("")?endData1:endData;

        System.out.println("开始时间"+startData);
        System.out.println("结束时间"+endData);

        PageHelper.startPage(pageNo,pageSize);

        List<SysUser> sysUserList = sysUserMapper.searchWithConditionForUser(startData, endData, userName);

        System.out.println(sysUserList);

        PageInfo<SysUser> sysUserPageInfo = new PageInfo<SysUser>(sysUserList);


        return sysUserPageInfo;


    }
}
