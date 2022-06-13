package com.hezhi3f.controller;

import com.hezhi3f.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final String INVOKE_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getEntity/{id}")
    public Result getPaymentEntityById(@PathVariable("id") Integer id) {
        ResponseEntity<Result> entity = restTemplate.getForEntity(INVOKE_URL + "/payment/get/" + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new Result(500, "fail", null);
        }
    }
}
