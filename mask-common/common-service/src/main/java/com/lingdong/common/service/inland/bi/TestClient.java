package com.lingdong.common.service.inland.bi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-inland-bi", path = "/test")
public interface TestClient {

    @GetMapping
    String get(@RequestParam("name") String name);

}
