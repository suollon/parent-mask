package com.lingdong.service.oversea_bi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@MapperScan(basePackages = "com.lingdong.service.oversea_bi.dao")
@SpringBootApplication
public class ServiceOverseaBiApplication {

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
        SpringApplication.run(ServiceOverseaBiApplication.class, args);
        System.out.println(String.format("http://localhost:%s%s/swagger-ui/index.html", staticPort, staticContextPath));
    }

}
