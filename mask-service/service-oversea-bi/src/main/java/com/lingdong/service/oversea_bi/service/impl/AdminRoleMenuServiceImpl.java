package com.lingdong.service.oversea_bi.service.impl;

import com.lingdong.service.oversea_bi.dao.AdminRoleMenuMapper;
import com.lingdong.service.oversea_bi.service.AdminRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台-角色和菜单关联表(AdminRoleMenu)表服务实现类
 *
 * @author wangwulei
 * @since 2020-11-25 14:30:09
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {

    @Autowired
    private AdminRoleMenuMapper adminRoleMenuMapper;

}