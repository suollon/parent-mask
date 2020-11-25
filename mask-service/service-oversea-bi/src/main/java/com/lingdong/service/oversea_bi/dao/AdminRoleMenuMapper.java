package com.lingdong.service.oversea_bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingdong.service.oversea_bi.entity.AdminRoleMenu;
import org.springframework.stereotype.Repository;

/**
 * 后台-角色和菜单关联表(AdminRoleMenu)表数据库访问层
 *
 * @author wangwulei
 * @since 2020-11-25 14:30:09
 */
@Repository
public interface AdminRoleMenuMapper extends BaseMapper<AdminRoleMenu> {

}