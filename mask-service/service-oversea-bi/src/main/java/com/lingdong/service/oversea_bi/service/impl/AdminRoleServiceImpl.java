package com.lingdong.service.oversea_bi.service.impl;

import com.lingdong.service.oversea_bi.dao.AdminRoleMapper;
import com.lingdong.service.oversea_bi.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台-角色信息表(AdminRole)表服务实现类
 *
 * @author wangwulei
 * @since 2020-11-23 16:50:43
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

}