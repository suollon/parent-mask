package com.lingdong.common.model.global_exception;

import lombok.Getter;

/**
 * 自定义系统异常
 */
@Getter
public class LingdongException extends RuntimeException {

    private int errorCode;
    private String errorMessage;

    public LingdongException(ErrorEnum errorEnum) {
        this.errorCode = errorEnum.getCode();
        this.errorMessage = errorEnum.getMessage();
    }

    public LingdongException(ErrorEnum errorEnum, String errorMessage) {
        this.errorCode = errorEnum.getCode();
        this.errorMessage = errorMessage;
    }
}
