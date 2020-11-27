package com.lingdong.service.oversea_bi.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.service.oversea_bi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 后台-用户信息表(AdminUser)表控制层
 */
@RestController
@RequestMapping("/admin-user")
public class AdminUserController implements AdminUserClient {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    @GetMapping
    public Result<AdminUserDto> selectByUsername(String username) {
        AdminUserDto adminUserDto = adminUserService.selectByUsername(username);
        return Result.ok(adminUserDto);
    }

    //注册
    @Override
    @PostMapping("/sign-up")
    public Result signUp(@Valid @RequestBody AdminUserSignUpParam param) {
        adminUserService.signUp(param);
        return Result.ok();
    }

    @GetMapping("/selectOne")
    public AdminUserDto selectOne() {
        AdminUserDto adminUser = this.adminUserService.selectByUsername("马云");
        return adminUser;
    }

    @GetMapping("/test")
    public String test() {
        return "hello world!";
    }
}