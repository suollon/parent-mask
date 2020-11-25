package com.lingdong.service.oversea_bi.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginParam {

    @NotBlank(message = "用户名，不能为空")
    private String username;

    @NotBlank(message = "密码，不能为空")
    private String password;

    @NotNull(message = "记住我，不能为空")
    private Boolean rememberMe;
}
