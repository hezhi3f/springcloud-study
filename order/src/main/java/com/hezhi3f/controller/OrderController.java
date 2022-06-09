package com.hezhi3f.controller;

import com.hezhi3f.entity.Payment;
import com.hezhi3f.result.Result;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getEntity/{id}")
    public Result getPaymentEntityById(@PathVariable("id") Integer id) {
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new Result(400, "查询错误", null);
        }
    }

}
