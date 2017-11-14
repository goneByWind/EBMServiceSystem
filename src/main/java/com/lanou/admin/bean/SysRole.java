package com.lanou.admin.bean;

import java.util.Date;
import java.util.List;

public class SysRole {
    private Integer id;

    private String name;

    private Integer status;

    private Integer sort;

    private String remark;

    private Date createTime;

    private Integer createId;

    private Date updateTime;

    private Integer updateId;

    // 一对一 一个角色 要有一个管理员来创建,这位管理员的id为createId
    private SysUser createUser;

    // 一对多 一个角色 可以同时由多个管理员担当
    private List<SysUser> SysUserList;

    private List<SysMenu> sysMenus;


    public List<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(List<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", createId=" + createId +
                ", updateTime=" + updateTime +
                ", updateId=" + updateId +
                ", createUser=" + createUser +
                ", SysUserList=" + SysUserList +
                ", sysMenus=" + sysMenus +
                '}';
    }

    public List<SysUser> getSysUserList() {
        return SysUserList;
    }

    public void setSysUserList(List<SysUser> sysUserList) {
        SysUserList = sysUserList;
    }

    public SysUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SysUser createUser) {
        this.createUser = createUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }
}