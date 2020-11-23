package com.lingdong.service.inland.bi.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.lingdong.common.service.inland.bi.TestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController implements TestClient {

    @Value("${user.name}")
    private String userName;

    @NacosValue("${user.password}")
    private String userPassword;

    @GetMapping
    public String get(@RequestParam String name) {
        return "hello" + name + "===userName=" + userName + "======userPassword=" + userPassword;
    }
}
