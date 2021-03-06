package com.hezhi3f.controller;

import com.hezhi3f.entity.Payment;
import com.hezhi3f.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public Result save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);
    }
}
