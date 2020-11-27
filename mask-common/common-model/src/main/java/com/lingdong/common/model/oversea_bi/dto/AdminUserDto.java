package com.lingdong.common.model.oversea_bi.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * 后台-用户信息表(AdminUser)实体类
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDto {
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

    private List<String> meunList;
}