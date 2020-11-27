package com.lingdong.common.util.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 对象拷贝工具类
 */
@Slf4j
public class BeanCopierUtil {

    /**
     * 列表转换
     */
    public static <T> T copyForClass(Object source, Class<T> clz) {
        T result;
        if (source == null) {
            return null;
        }
        try {
            result = clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("初始化失败e={}", e);
            throw new IllegalAccessError("无法初始化没有默认构函数的类");
        }
        BeanUtils.copyProperties(source, result);
        return result;
    }

    /**
     * Pojo 类型转换（字段名/类型相同则被复制）
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
            log.error("对象转换失败,{}", e);
            throw new RuntimeException("对象转换失败" + source + "_" + targetClass);
        }
    }
}
