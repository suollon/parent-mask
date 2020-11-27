package com.lingdong.service.oversea_bi.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.service.oversea_bi.entity.AdminUser;
import com.lingdong.service.oversea_bi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 后台-用户信息表(AdminUser)表控制层
 *
 * @author makejava
 * @since 2020-11-23 15:18:48
 */
@RestController
@RequestMapping("/admin-user")
public class AdminUserController implements AdminUserClient {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminUserService.loadUserByUsername(username);
    }

    @Override
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
    public AdminUser selectOne() {
        UserDetails userDetails = this.adminUserService.loadUserByUsername("马云");
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(userDetails.getUsername());
        adminUser.setPassword(userDetails.getPassword());
        return adminUser;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public String test() {
        return "hello world!";
    }
}