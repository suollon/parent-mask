package com.lingdong.service.oversea.bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingdong.service.oversea.bi.entity.AdminUser;

import java.util.List;

/**
 * 后台-用户信息表(AdminUser)表数据库访问层
 */
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    List<String> selectMenuListByUserId(Long userId);
}