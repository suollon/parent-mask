package com.lingdong.service.oversea_bi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台-用户信息表(AdminUser)实体类
 *
 * @author makejava
 * @since 2020-11-23 15:18:46
 */
public class AdminUser implements Serializable {
    private static final long serialVersionUID = -12958178611280764L;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 用户账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户昵称
    */
    private String nickName;
    /**
    * 用户邮箱
    */
    private String email;
    /**
    * 手机号码
    */
    private String phone;
    /**
    * 用户性别（MAN男 WOMAN女）
    */
    private String sex;
    /**
    * 头像地址
    */
    private String imageUrl;
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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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