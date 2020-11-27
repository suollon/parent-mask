package com.lingdong.service.oversea_bi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.lingdong.service.oversea.bi.dao")
@SpringBootApplication
public class ServiceOverseaBiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOverseaBiApplication.class, args);
    }

}
