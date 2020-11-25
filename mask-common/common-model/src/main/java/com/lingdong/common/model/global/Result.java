package com.lingdong.common.model.global;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回值模型
 */
@Getter
@Setter
public class Result<T> {

    private Integer code;
    private String message;
    private T data;
    private long timestamp = System.currentTimeMillis();

    public Result() {}

    public static <T> Result<T> ok() {
        Result<T> r = new Result<>();
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setMessage(ErrorEnum.SUCCESS.getMessage());
        return r;
    }

    public static <T> Result<T> ok(T result) {
        Result<T> r = new Result<>();
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setMessage(ErrorEnum.SUCCESS.getMessage());
        r.setData(result);
        return r;
    }

    public static <T> Result<T> error(ErrorEnum errorEnum) {
        Result<T> r = new Result<>();
        r.setCode(errorEnum.getCode());
        r.setMessage(errorEnum.getMessage());
        return r;
    }

    public static <T> Result<T> error(ErrorEnum errorEnum, String message) {
        Result<T> r = new Result<>();
        r.setCode(errorEnum.getCode());
        r.setMessage(message);
        return r;
    }

    /**
     * 为统一异常拦截提供的方法，不建议在业务代码中使用；
     */
    protected static <T> Result<T> error(int errorCode, String message, T data) {
        Result<T> r = new Result<>();
        r.setCode(errorCode);
        r.setMessage(message);
        r.setData(data);
        return r;
    }
}
