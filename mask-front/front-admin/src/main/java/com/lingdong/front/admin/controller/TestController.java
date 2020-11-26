package com.lingdong.front.admin.controller;

import com.lingdong.common.model.global_exception.ErrorEnum;
import com.lingdong.common.model.global_exception.LingdongException;
import com.lingdong.common.model.global_exception.Result;
import com.lingdong.common.model.inland_bi.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestClient testClient;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public Result<String> get(@RequestParam("name") String name) {
        Result<String> result = testClient.get(name);
        return Result.ok(result.getData());
    }

    @GetMapping("/error")
    public Result<String> getError() {
        try {
            int i = 10 / 0;
        } catch (RuntimeException e) {
            throw new LingdongException(ErrorEnum.E100500, "ceshi");
        }
        return Result.ok();
    }

    @GetMapping("/package")
    public Result<String> getPackage() {
        Map<String, Object> startClassMap = applicationContext.getBeansWithAnnotation(SpringBootApplication.class);
        if (!CollectionUtils.isEmpty(startClassMap)) {
            Package aPackage = startClassMap.values().toArray()[0].getClass().getPackage();
            return Result.ok(aPackage.getName());
        }
        return Result.ok();
    }

}
