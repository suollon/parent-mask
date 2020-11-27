package com.lingdong.service.oversea_bi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台-角色信息表(AdminRole)实体类
 *
 * @author wangwulei
 * @since 2020-11-23 16:50:43
 */
public class AdminRole implements Serializable {
    private static final long serialVersionUID = -41838453379505404L;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 显示顺序
    */
    private Integer sort;
    /**
    * 帐号状态（NORMAL正常 STOP停用）
    */
    private String status;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 更新时间
    */
    private Date updatedTime;

        
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
        
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
        
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
        
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}