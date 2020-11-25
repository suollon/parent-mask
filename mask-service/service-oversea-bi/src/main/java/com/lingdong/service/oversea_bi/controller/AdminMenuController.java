package com.lingdong.service.oversea_bi.controller;

import com.lingdong.service.oversea_bi.service.AdminMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台-菜单权限表(AdminMenu)表控制层
 *
 * @author wangwulei
 * @since 2020-11-25 14:28:47
 */
@RestController
@RequestMapping("adminMenu")
public class AdminMenuController {

    @Resource
    private AdminMenuService adminMenuService;


}