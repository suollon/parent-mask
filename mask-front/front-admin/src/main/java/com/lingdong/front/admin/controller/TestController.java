package com.lingdong.front.admin.controller;

import com.lingdong.common.model.global.ErrorEnum;
import com.lingdong.common.model.global.LingdongException;
import com.lingdong.common.model.global.Result;
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
    public Result<String> get(@RequestParam("name") String name) {
        String s = testClient.get(name);
        return Result.ok(s);
    }

    // ArithmeticException
    @GetMapping("/error")
    public Result<String> gete() {
        try {
            int i = 10 / 0;
        } catch (RuntimeException e) {
            throw new LingdongException(ErrorEnum.E100500, "ceshi");
        }
        return Result.ok();
    }

}
