package com.lingdong.service.oversea_bi.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.common.model.oversea_bi.param.LoginParam;
import com.lingdong.common.util.utils.JwtTokenUtil;
import com.lingdong.common.util.utils.RedisKeyUtil;
import com.lingdong.service.oversea_bi.entity.AdminUser;
import com.lingdong.service.oversea_bi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminUserService.loadUserByUsername(username);
    }

    //注册
    @Override
    @PostMapping("/sign-up")
    public Result signUp(@Valid @RequestBody AdminUserSignUpParam param) {
        adminUserService.signUp(param);
        return Result.ok();
    }

    //登录
    @Override
    @PostMapping("/login")
    public Result login(@Valid @RequestBody LoginParam param) {
        AdminUserDto userFromDatabase = this.adminUserService.selectByUsername(param.getUsername());
        if (userFromDatabase == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!passwordEncoder.matches(param.getPassword(), userFromDatabase.getPassword())) {
            throw new RuntimeException("密码不正确");
        }
        String token = JwtTokenUtil.createToken(userFromDatabase.getUserId(), userFromDatabase.getUsername(), userFromDatabase.getMeunList(), true);
        redisTemplate.opsForValue().set(RedisKeyUtil.getTokenKey(userFromDatabase.getUserId()), token);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        return Result.ok();
    }

    //退出
    @Override
    @PostMapping("/logout")
    public Result logout() {
        // 删除缓存中的token

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