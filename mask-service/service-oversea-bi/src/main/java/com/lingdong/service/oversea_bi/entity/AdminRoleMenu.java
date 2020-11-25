package com.lingdong.service.oversea_bi.entity;

import java.io.Serializable;

/**
 * 后台-角色和菜单关联表(AdminRoleMenu)实体类
 *
 * @author wangwulei
 * @since 2020-11-25 14:30:09
 */
public class AdminRoleMenu implements Serializable {
    private static final long serialVersionUID = 225274430523813301L;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;

        
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
        
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}