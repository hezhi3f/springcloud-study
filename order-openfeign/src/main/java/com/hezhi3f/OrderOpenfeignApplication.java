package com.hezhi3f;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignApplication.class, args);
    }
}
