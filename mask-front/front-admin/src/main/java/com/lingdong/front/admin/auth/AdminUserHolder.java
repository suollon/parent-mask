package com.lingdong.front.admin.auth;

import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;

/**
 * 用户信息持有者（ThreadLocal）
 * 1，在拦截器中，将用户信息保存入当前线程的 ThreadLocal
 * 2，在参数解析器中，取出当前线程 ThreadLocal 中的用户信息，注入到参数 AdminUserDto 中
 */
public class AdminUserHolder {

    private static final ThreadLocal<AdminUserDto> threadLocalLoginUserInfo = new ThreadLocal<>();

    public static AdminUserDto getAdminUser() {
        return threadLocalLoginUserInfo.get();
    }

    public static void setAdminUser(AdminUserDto adminUserDto) {
        threadLocalLoginUserInfo.set(adminUserDto);
    }

    public static void removeAdminUser() {
        threadLocalLoginUserInfo.remove();
    }
}
