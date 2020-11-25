package com.lingdong.middleware.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MiddlewareGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlewareGatewayApplication.class, args);
    }

}
