package com.lingdong.service.oversea_bi.service.impl;

import com.lingdong.service.oversea_bi.dao.AdminMenuMapper;
import com.lingdong.service.oversea_bi.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台-菜单权限表(AdminMenu)表服务实现类
 *
 * @author wangwulei
 * @since 2020-11-25 14:28:50
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Autowired
    private AdminMenuMapper adminMenuMapper;

}