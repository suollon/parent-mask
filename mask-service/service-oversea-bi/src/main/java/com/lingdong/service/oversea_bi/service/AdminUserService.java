package com.lingdong.service.oversea_bi.service;

import com.lingdong.service.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.service.oversea_bi.config.AdminUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 后台-用户信息表(AdminUser)表服务接口
 */
public interface AdminUserService extends UserDetailsService {

    void signUp(AdminUserSignUpParam param);

    AdminUserDto selectByUsername(String username);

}