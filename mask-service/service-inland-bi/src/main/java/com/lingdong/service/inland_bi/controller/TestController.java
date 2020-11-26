package com.lingdong.service.inland_bi.controller;

import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.inland_bi.client.TestClient;
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

    @GetMapping
    public Result<String> get(@RequestParam String name) {
        String result = "hello" + name + "===userName=" + userName;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ok(result);
    }
}
