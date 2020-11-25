package com.lingdong.service.oversea_bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingdong.service.oversea_bi.entity.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台-用户信息表(AdminUser)表数据库访问层
 */
@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    List<String> selectMenuListByUserId(Long userId);
}