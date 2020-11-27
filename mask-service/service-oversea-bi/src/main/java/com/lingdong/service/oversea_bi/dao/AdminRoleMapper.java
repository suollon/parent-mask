package com.lingdong.service.oversea_bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingdong.common.model.oversea_bi.param.AdminRoleParam;
import com.lingdong.service.oversea_bi.entity.AdminRole;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 后台-角色信息表(AdminRole)表数据库访问层
 *
 * @author wangwulei
 * @since 2020-11-23 16:50:43
 */
@Repository
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    int insertBatch(Set<AdminRoleParam> roles);
}