package com.lingdong.common.model.oversea_bi.client;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.common.model.oversea_bi.param.LoginParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "service-oversea-bi", path = "/service-oversea-bi/admin-user")
public interface AdminUserClient extends UserDetailsService {

    @PostMapping("/sign-up")
    Result signUp(@Valid @RequestBody AdminUserSignUpParam param);

    @PostMapping("/login")
    Result login(@Valid @RequestBody LoginParam param);

    @PostMapping("/logout")
    Result logout();
}
