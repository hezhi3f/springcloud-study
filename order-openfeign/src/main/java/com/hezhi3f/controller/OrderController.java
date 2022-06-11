package com.hezhi3f.controller;

import com.hezhi3f.result.Result;
import com.hezhi3f.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public Result getPaymentById(@PathVariable("id") Integer id) {
        System.out.println("Order service controller");
        return paymentFeignService.getPaymentById(id);
    }


}
