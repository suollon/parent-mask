package com.lingdong.service.oversea_bi.entity;

import lombok.*;

/**
 * 后台-用户和角色关联表(AdminUserRole)实体类
 *
 * @author wangwulei
 * @since 2020-11-25 14:29:41
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserRole {
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 角色ID
    */
    private Long roleId;
}