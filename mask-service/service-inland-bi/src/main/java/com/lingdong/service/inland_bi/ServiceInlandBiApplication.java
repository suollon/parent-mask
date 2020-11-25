package com.lingdong.service.inland_bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceInlandBiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInlandBiApplication.class, args);
    }

}
