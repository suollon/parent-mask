package com.lingdong.service.oversea.bi.service;

import com.lingdong.service.oversea.bi.config.AdminUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 后台-用户信息表(AdminUser)表服务接口
 */
public interface AdminUserService extends UserDetailsService {

    AdminUserDto selectByUsername(String username);
}