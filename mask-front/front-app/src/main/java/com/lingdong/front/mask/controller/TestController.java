package com.lingdong.front.mask.controller;

import com.lingdong.common.model.global_exception.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
@Api(tags = "测试", authorizations = {@Authorization("kikixi")})
public class TestController {

    @GetMapping
    public Result get() {
        return Result.ok();
    }

    @PostMapping
    public Result post() {
        return Result.ok();
    }

    @PutMapping
    public Result put() {
        return Result.ok();
    }

}
