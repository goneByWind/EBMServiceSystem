package com.lanou.admin.bean;

import java.util.Date;
import java.util.List;

public class SysRole {
    private Integer id;

    private String name;

    private Integer status;

    private Integer sort;

    private Date createTime;

    private Integer createId;

    private Date updateTime;

    private Integer updateId;

    private String remark;

    /*一对多:一个角色对应多个管理员(用不到)*/
//    private List<SysUser> sysUserList;
//
//    @Override
//    public String toString() {
//        return "SysRole{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", status=" + status +
//                ", sort=" + sort +
//                ", createTime=" + createTime +
//                ", createId=" + createId +
//                ", updateTime=" + updateTime +
//                ", updateId=" + updateId +
//                ", remark='" + remark + '\'' +
//                ", sysUserList=" + sysUserList +
//                '}';
//    }
//
//    public List<SysUser> getSysUserList() {
//        return sysUserList;
//    }
//
//    public void setSysUserList(List<SysUser> sysUserList) {
//        this.sysUserList = sysUserList;
//    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}