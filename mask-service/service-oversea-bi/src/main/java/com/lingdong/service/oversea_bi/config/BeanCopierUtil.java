package com.lingdong.service.oversea_bi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 对象拷贝工具类
 *
 * @author wangwl
 * @date 2020/5/20 22:51
 */
public class BeanCopierUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCopierUtil.class);

    private BeanCopierUtil() {
    }

    public static <T> T copyForClass(Object source, Class<T> clz) {
        T result;
        if (source == null) {
            return null;
        }
        try {
            result = clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("初始化失败e={}", e);
            throw new IllegalAccessError("无法初始化没有默认构函数的类");
        }
        BeanUtils.copyProperties(source, result);
        return result;
    }

    /**
     * Pojo 类型转换（字段名/类型相同则被复制）
     *
     * @return
     */
    public static <E> List<E> copyForList(List source, Class<E> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            List result = source.getClass().newInstance();
            for (Object code : source) {
                result.add(copyForClass(code, targetClass));
            }
            return result;
        } catch (Exception e) {
            LOGGER.error("对象转换失败,{}", e);
            throw new RuntimeException("对象转换失败" + source + "_" + targetClass);
        }
    }
}
