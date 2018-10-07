package com.idea.spbmodeldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.idea.spbmodeldemo.dao")
public class SpbModelClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbModelClientDemoApplication.class, args);
    }
}
