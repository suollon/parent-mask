package com.lingdong.front.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@EnableFeignClients(basePackages = "com.lingdong.common.model")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.lingdong.front.admin", "com.lingdong.common.model"})
public class FrontAdminApplication {

    @Value("${server.port}")
    private String port;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static String staticPort;
    private static String staticContextPath;

    @PostConstruct
    public void init() {
        staticPort = port;
        staticContextPath = contextPath;
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontAdminApplication.class, args);
        System.out.println(String.format("http://localhost:%s%s/swagger-ui/index.html", staticPort, staticContextPath));
    }

}
