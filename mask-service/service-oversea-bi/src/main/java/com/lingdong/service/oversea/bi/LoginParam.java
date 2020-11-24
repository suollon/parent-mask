package com.lingdong.service.oversea.bi;

import lombok.Data;

@Data
public class LoginParam {
    private String username;
    private String password;
    private Boolean rememberMe;
}
