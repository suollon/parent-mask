package com.lingdong.front.admin.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.common.model.oversea_bi.param.LoginParam;
import com.lingdong.common.util.utils.RedisKeyUtil;
import com.lingdong.front.admin.auth.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin-user")
public class AdminUserController {

    @Autowired
    private AdminUserClient adminUserClient;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/sign-up")
    public Result signUp(@Valid @RequestBody AdminUserSignUpParam param) {
        return adminUserClient.signUp(param);
    }

    @PostMapping("/login")
    public Result login(@Valid @RequestBody LoginParam param, HttpServletResponse response) {
        AdminUserDto userFromDatabase = adminUserClient.selectByUsername(param.getUsername()).getData();
        if (userFromDatabase == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!passwordEncoder.matches(param.getPassword(), userFromDatabase.getPassword())) {
            throw new RuntimeException("密码不正确");
        }
        String token = JwtTokenUtil.createToken(userFromDatabase.getUserId(), userFromDatabase.getUsername(), userFromDatabase.getMeunList(), true);
        redisTemplate.opsForValue().set(RedisKeyUtil.getTokenKey(userFromDatabase.getUserId()), token);
        response.setHeader(HttpHeaders.AUTHORIZATION, token);
        return Result.ok();
    }

    //退出
    @PostMapping("/logout")
    // TODO 通过注解注入当前登录的用户;
    public Result logout(Long userId) {
        // 删除缓存中的token
        redisTemplate.delete(RedisKeyUtil.getTokenKey(userId));
        return Result.ok();
    }
}
