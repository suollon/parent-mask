package com.lingdong.service.oversea_bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingdong.service.oversea_bi.entity.AdminUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台-用户和角色关联表(AdminUserRole)表数据库访问层
 *
 * @author wangwulei
 * @since 2020-11-25 14:29:41
 */
@Repository
public interface AdminUserRoleMapper extends BaseMapper<AdminUserRole> {

    int insertBatch(List<AdminUserRole> userRoles);
}