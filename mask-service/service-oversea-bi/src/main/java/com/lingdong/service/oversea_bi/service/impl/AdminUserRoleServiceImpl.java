package com.lingdong.service.oversea_bi.service.impl;

import com.lingdong.service.oversea_bi.dao.AdminUserRoleMapper;
import com.lingdong.service.oversea_bi.service.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台-用户和角色关联表(AdminUserRole)表服务实现类
 *
 * @author wangwulei
 * @since 2020-11-25 14:29:41
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

}