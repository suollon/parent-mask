package com.lingdong.common.model.global_exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.netflix.client.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 目前仅添加了捕获自定义异常，和参数绑定校验相关的异常；
 * 如果捕获其他异常，可自行添加；
 */
@Slf4j
@RestControllerAdvice
public class LingdongExceptionHandler {

    /*********************** 参数操作异常 ***********************/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException 异常", e);
        return handleParameterException(e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        log.error("BindException 异常", e);
        return handleParameterException(e.getBindingResult());
    }

    private Result handleParameterException(BindingResult bindingResult) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        Map<String, String> errorMap = errors.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return Result.error(ErrorEnum.E100400.getCode(), errors.get(0).getDefaultMessage(), errorMap);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException 异常", e);
        return Result.error(ErrorEnum.E100400.getCode(), e.getMessage(), e.toString());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException 异常", e);
        String fieldName = ((JsonMappingException) e.getCause()).getPath().get(0).getFieldName();
        String message = String.format("字段【%s】格式不正确！", fieldName);
        return Result.error(ErrorEnum.E100400.getCode(), message, e.toString());
    }

    /*********************** 自定义系统业务异常 ***********************/
    @ExceptionHandler(LingdongException.class)
    public Result handleStandardException(LingdongException e) {
        log.error("LingdongException 异常", e);
        return Result.error(e.getErrorCode(), e.getErrorMessage(), e.getStackTrace()[0]);
    }

    /*********************** 其他系统异常 ***********************/
    @ExceptionHandler(ClientException.class)
    public Result handleRuntimeException(ClientException e) {
        log.error("ClientException 异常", e);
        return Result.error(ErrorEnum.E100500.getCode(), ErrorEnum.E100500.getMessage(), e.getStackTrace()[0]);
    }

    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException 异常", e);
        return Result.error(ErrorEnum.E100500.getCode(), ErrorEnum.E100500.getMessage(), e.getStackTrace()[0]);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("Exception 异常", e);
        return Result.error(ErrorEnum.E100500.getCode(), ErrorEnum.E100500.getMessage(), e.getStackTrace()[0]);
    }
}
