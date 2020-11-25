package com.lingdong.service.oversea_bi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台-菜单权限表(AdminMenu)实体类
 *
 * @author wangwulei
 * @since 2020-11-25 14:28:45
 */
public class AdminMenu implements Serializable {
    private static final long serialVersionUID = 531376508476329790L;
    /**
    * 菜单ID
    */
    private Long menuId;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 父菜单ID
    */
    private Long parentId;
    /**
    * 路由地址
    */
    private String path;
    /**
    * 显示顺序
    */
    private Integer sort;
    /**
    * 菜单类型（MENU菜单 BUTTON按钮）
    */
    private String menuType;
    /**
    * 菜单状态（NORMAL正常 STOP停用）
    */
    private String status;
    /**
    * 菜单图标
    */
    private String imageUrl;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 更新时间
    */
    private Date updatedTime;

        
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
        
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
        
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
        
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
        
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
        
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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