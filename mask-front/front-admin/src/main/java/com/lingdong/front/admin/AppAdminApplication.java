package com.lingdong.front.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.lingdong.common.service")
@EnableDiscoveryClient
@SpringBootApplication
public class AppAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAdminApplication.class, args);
    }

}
