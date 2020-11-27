package com.lingdong.common.util.constants;

/**
 * @description Spring Security相关配置常量
 */
public interface SecurityConstant {

    // 角色的key
    String MENU_CLAIMS = "menu";

    // rememberMe 为 false 的时候过期时间是1个小时
    long EXPIRATION = 60 * 60L;

    // rememberMe 为 true 的时候过期时间是7天
    long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;

    // JWT签名密钥硬编码到应用程序代码中，应该存放在配置文件中。
    String JWT_SECRET_KEY = "UkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w";

    String TOKEN_PREFIX = "Bearer ";
    String TOKEN_ISS = "lingdong";
}
