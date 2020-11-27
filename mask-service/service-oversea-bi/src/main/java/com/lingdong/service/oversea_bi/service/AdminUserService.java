package com.lingdong.service.oversea_bi.service;

import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;

/**
 * 后台-用户信息表(AdminUser)表服务接口
 */
public interface AdminUserService {

    AdminUserDto selectByUsername(String username);

    void signUp(AdminUserSignUpParam param);
}