package com.lingdong.front.admin.config;

import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] SWAGGER_WHITE_LIST = {"/swagger-ui.html", "/swagger-ui/*",
            "/swagger-resources/**", "/v2/api-docs", "/v3/api-docs", "/webjars/**"};

    @Autowired
    private AdminUserClient adminUserClient;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserClient).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()// 禁用 CSRF
                .authorizeRequests()
                .antMatchers(SWAGGER_WHITE_LIST).permitAll()// swagger
                .antMatchers(HttpMethod.POST, "/admin-user/login").permitAll()// 登录接口
                .antMatchers("/**").authenticated()// 指定路径下的资源需要验证了的用户才能访问
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .anyRequest().permitAll()// 其他都放行了
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManagerBean()))//添加自定义Filter
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// 不需要session（不创建会话）
    }

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean("authenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
