package com.lingdong.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一返回值模型
 */
@Getter
@Setter
public class Result<T> {

    private Integer code = 0;
    private String message = "成功！";
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
        r.setSuccess(true);
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setMessage(ErrorEnum.SUCCESS.getMessage());
        r.setResult(result);
        return r;
    }

    public static <T> Result<T> ok(T result, LoginUserInfo loginUserInfo) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setMessage(ErrorEnum.SUCCESS.getMessage());
        r.setResult(result);
        if (loginUserInfo != null) {
            r.setLunaSessionId(loginUserInfo.getLunaSessionId());
            r.setLunaBuryUid(String.valueOf(loginUserInfo.getGyUserId()));
        }
        return r;
    }

    public static <T> Result<T> ok(T result, ErrorEnum errorEnum, LoginUserInfo loginUserInfo) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(errorEnum.getCode());
        r.setMessage(errorEnum.getMessage());
        r.setResult(result);
        if (loginUserInfo != null) {
            r.setLunaSessionId(loginUserInfo.getLunaSessionId());
            r.setLunaBuryUid(String.valueOf(loginUserInfo.getGyUserId()));
        }
        return r;
    }

    public static <T> Result<T> error(String message) {
        return error(ErrorEnum.BAD_PARAMETER.getCode(), message);
    }

    /**
     * 此方法不建议使用
     * 不建议直接传入自定义 code 作为返回码；而应该——
     * 1，先定义 {@link ErrorEnum}，在错误枚举中定义错误码，
     * 2，再调用 {@link Result#error(com.gyjx.galaxy.luna.app.common.exceptionhandler.ErrorEnum)}
     */
    @Deprecated
    public static <T> Result<T> error(int code, String message) {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static <T> Result<T> error(ErrorEnum errorEnum) {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(errorEnum.getCode());
        r.setMessage(errorEnum.getMessage());
        return r;
    }

    /*********************** 链式调用方法 ***********************/
    public Result<T> success(boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> code(int code) {
        this.code = code;
        return this;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> result(T result) {
        this.result = result;
        return this;
    }

    public static <T> Result<T> build() {
        return new Result<>();
    }
}
