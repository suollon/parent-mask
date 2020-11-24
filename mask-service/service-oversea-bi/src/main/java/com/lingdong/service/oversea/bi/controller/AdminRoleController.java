package com.lingdong.service.oversea.bi.controller;

import com.lingdong.service.oversea.bi.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台-角色信息表(AdminRole)表控制层
 *
 * @author wangwulei
 * @since 2020-11-23 16:50:43
 */
@RestController
@RequestMapping("adminRole")
public class AdminRoleController {

    @Autowired
    private AdminRoleService adminRoleService;

}