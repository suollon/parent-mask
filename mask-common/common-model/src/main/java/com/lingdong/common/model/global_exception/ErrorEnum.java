package com.lingdong.common.model.global_exception;

import lombok.Getter;

/**
 * 成功码   100000
 * 错误码   xxxyyy   前三位为模块码，代表具体哪一个项目模板；后三位为具体的业务错误码
 * 错误码   100xxx   100开头，代表系统通用异常
 */
@Getter
public enum ErrorEnum {

    /*********************** 系统通用异常 ***********************/
    SUCCESS(100000, "操作成功！"),
    E100400(100400, "参数异常！"),
    E100401(100401, "未登录。"),
    E100500(100500, "系统异常！"),

    /*********************** 国内BI异常 ***********************/
    E101000(101000, ""),

    /*********************** 国内SDK异常 ***********************/
    E102000(102000, ""),

    /*********************** 国内支付异常 ***********************/
    E103000(103000, ""),

    /*********************** 海外BI异常 ***********************/
    E104000(104000, ""),

    /*********************** 海外SDK异常 ***********************/
    E105000(105000, ""),

    /*********************** 海外支付异常 ***********************/
    E106000(106000, ""),

    ;

    private int code;
    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
