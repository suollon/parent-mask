package com.lingdong.front.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.lingdong.common.service")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.lingdong.front.admin", "com.lingdong.common.model.global"})
public class FrontAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontAdminApplication.class, args);
    }

}
