package com.lingdong.service.oversea_bi.param;

import lombok.Data;

import java.util.Set;

@Data
public class AdminUserSignUpParam {

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
     * 角色集合
     */
    private Set<Long> roleIds;
}
