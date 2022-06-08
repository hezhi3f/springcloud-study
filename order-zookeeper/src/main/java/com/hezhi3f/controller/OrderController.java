package com.hezhi3f.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String INVOKE_URL = "http://payment-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/zk")
    public String orderZK() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
