package com.lingdong.common.model.oversea_bi.client;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@FeignClient(name = "service-oversea-bi", path = "/service-oversea-bi/admin-user")
public interface AdminUserClient {

    @GetMapping
    Result<AdminUserDto> selectByUsername(@RequestParam("username") String username);

    @PostMapping("/sign-up")
    Result signUp(@Valid @RequestBody AdminUserSignUpParam param);

}
