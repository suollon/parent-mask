package com.lingdong.common.util.utils;

public class RedisKeyUtil {

    private static final String PROJECT = "mask";
    private static final String MOOUDLE_SECURITY = "security";
    private static final String MOOUDLE_SERVICE_OVER_BI = "service-oversea-bi";
    private static final String SEPARATOR = ":";

    public static String getTokenKey(Long userId) {
        return new StringBuilder()
                .append(PROJECT).append(SEPARATOR)
                .append(MOOUDLE_SECURITY).append(SEPARATOR)
                .append("token").append(SEPARATOR)
                .append(userId)
                .toString();
    }

}
