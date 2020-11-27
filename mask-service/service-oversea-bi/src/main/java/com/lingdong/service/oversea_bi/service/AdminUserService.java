package com.lingdong.service.oversea_bi.service;

import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 后台-用户信息表(AdminUser)表服务接口
 */
public interface AdminUserService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    AdminUserDto selectByUsername(String username);

    void signUp(AdminUserSignUpParam param);
}