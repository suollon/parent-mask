package com.lingdong.common.model.inland_bi.client;

import com.lingdong.common.model.global_exception.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-inland-bi", path = "/service-inland-bi/test")
public interface TestClient {

    @GetMapping
    Result<String> get(@RequestParam("name") String name);

}
