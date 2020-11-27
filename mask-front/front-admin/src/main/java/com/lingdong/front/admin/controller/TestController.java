package com.lingdong.front.admin.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.inland_bi.client.TestClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.front.admin.auth.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestClient testClient;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public Result<AdminUserDto> get(@RequestParam("name") String name, @ApiIgnore @CurrentUser AdminUserDto adminUser) {

        return Result.ok(adminUser);
    }

}
