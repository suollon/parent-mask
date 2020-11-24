package com.lingdong.common.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目前仅添加了捕获自定义异常，和参数绑定校验相关的异常；
 * 如果捕获其他异常，可自行添加；
 */
@Slf4j
@RestControllerAdvice
public class LunaExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return handleParameterException(e.getBindingResult()).message("参数校验异常");
    }

    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        return handleParameterException(e.getBindingResult()).message("参数绑定异常");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.build().success(false).code(ErrorEnum.BAD_PARAMETER.getCode()).message(e.getMessage());
    }

    @ExceptionHandler(LunaException.class)
    public Result handleStandardException(LunaException e) {
        return Result.build().success(false).code(e.getErrorCode()).message(e.getErrorMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException异常", e);
        return Result.build().success(false).code(ErrorEnum.INTERNAL_ERROR.getCode()).message(e.toString());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("Exception异常", e);
        return Result.build().success(false).code(ErrorEnum.INTERNAL_ERROR.getCode()).message(e.toString());
    }

    private Result handleParameterException(BindingResult bindingResult) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        Map<String, String> map = new HashMap<>();
        for (FieldError error : errors) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return Result.build().success(false).code(ErrorEnum.BAD_PARAMETER.getCode()).result(map);
    }

}
