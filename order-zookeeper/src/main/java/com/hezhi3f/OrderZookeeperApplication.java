package com.hezhi3f;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderZookeeperApplication.class, args);
    }
}
