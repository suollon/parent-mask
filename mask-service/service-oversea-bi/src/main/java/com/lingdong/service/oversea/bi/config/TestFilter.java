package com.lingdong.service.oversea.bi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //1，获取username与password
        String username = "kikixi";
        String password = "kikixi";
        //2，从数据库或缓存中获取用户密码及权限
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        passwordEncoder.matches(password, userDetails.getPassword());


        return super.attemptAuthentication(request, response);
    }
}
