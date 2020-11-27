package com.lingdong.front.admin.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.common.model.oversea_bi.param.LoginParam;
import com.lingdong.common.util.utils.JwtTokenUtil;
import com.lingdong.common.util.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result login(@Valid @RequestBody LoginParam param) {
        AdminUserDto userFromDatabase = adminUserClient.selectByUsername(param.getUsername()).getData();
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
    @PostMapping("/logout")
    public Result logout() {
        // 删除缓存中的token

        return Result.ok();
    }
}
