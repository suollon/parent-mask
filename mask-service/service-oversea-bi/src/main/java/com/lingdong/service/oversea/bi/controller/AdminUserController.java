package com.lingdong.service.oversea.bi.controller;

import com.lingdong.service.oversea.bi.LoginParam;
import com.lingdong.service.oversea.bi.config.AdminUserDto;
import com.lingdong.service.oversea.bi.config.JwtTokenUtil;
import com.lingdong.service.oversea.bi.config.RedisKeyUtil;
import com.lingdong.service.oversea.bi.entity.AdminUser;
import com.lingdong.service.oversea.bi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * 后台-用户信息表(AdminUser)表控制层
 *
 * @author makejava
 * @since 2020-11-23 15:18:48
 */
@RestController
@RequestMapping("/admin-user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public void login(@RequestBody LoginParam param) {
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
        return;
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