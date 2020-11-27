package com.lingdong.service.oversea_bi.param;

import lombok.Data;

@Data
public class AdminRoleParam {

    /**
     * 角色名称
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
}
