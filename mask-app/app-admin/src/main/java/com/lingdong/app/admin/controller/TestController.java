package com.lingdong.app.admin.controller;

import com.lingdong.common.service.inland.bi.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestClient testClient;

    @GetMapping
    public String get(@RequestParam String name) {
        return testClient.get(name);
    }

}
