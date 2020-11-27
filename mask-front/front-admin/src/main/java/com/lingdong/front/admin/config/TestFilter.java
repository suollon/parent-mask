package com.lingdong.front.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @Component
//extends UsernamePasswordAuthenticationFilter
public class TestFilter  {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    // @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            AdminUserDto adminUser = new ObjectMapper().readValue(request.getInputStream(), AdminUserDto.class);
            //1，从数据库或缓存中获取用户密码及权限
            UserDetails userDetails = userDetailsService.loadUserByUsername(adminUser.getUsername());
            if (userDetails == null) {
                throw new RuntimeException("用户不存在");
            }
            //2，比对密码是否一致
            boolean matches = passwordEncoder.matches(adminUser.getPassword(), userDetails.getPassword());
            if (!matches) {
                throw new RuntimeException("密码不正确");
            }
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(adminUser.getUsername(), adminUser.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取用户信息异常");
        }
    }

    // @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        // super.successfulAuthentication(request, response, chain, authResult);
    }

    // @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        // super.unsuccessfulAuthentication(request, response, failed);
    }
}
