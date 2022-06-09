package com.hezhi3f.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String INVOKE_URL = "http://payment-consul-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consul")
    public String consul() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
