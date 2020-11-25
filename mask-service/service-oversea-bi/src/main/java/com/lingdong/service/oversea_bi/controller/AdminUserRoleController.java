package com.lingdong.service.oversea_bi.controller;

import com.lingdong.service.oversea_bi.service.AdminUserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台-用户和角色关联表(AdminUserRole)表控制层
 *
 * @author wangwulei
 * @since 2020-11-25 14:29:41
 */
@RestController
@RequestMapping("adminUserRole")
public class AdminUserRoleController {

    @Resource
    private AdminUserRoleService adminUserRoleService;


}