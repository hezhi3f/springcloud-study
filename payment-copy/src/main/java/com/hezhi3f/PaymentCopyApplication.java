package com.hezhi3f;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentCopyApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentCopyApplication.class, args);
    }
}
