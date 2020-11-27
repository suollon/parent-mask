package com.lingdong.service.oversea_bi.controller;

import com.lingdong.service.oversea_bi.service.AdminRoleMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台-角色和菜单关联表(AdminRoleMenu)表控制层
 *
 * @author wangwulei
 * @since 2020-11-25 14:30:09
 */
@RestController
@RequestMapping("adminRoleMenu")
public class AdminRoleMenuController {

    @Resource
    private AdminRoleMenuService adminRoleMenuService;


}