package com.hezhi3f.controller;

import com.hezhi3f.entity.Payment;
import com.hezhi3f.result.Result;
import com.hezhi3f.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/save")
    public Result save(@RequestBody Payment payment) {
        Integer result = service.save(payment);
        if (result > 0) {
            return Result.success(result);
        } else {
            return new Result(300, "插入失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public Result getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = service.getPaymentById(id);

        if (payment == null) {
            return new Result(300, "查询为空", null);
        } else {
            return new Result(200, "server-port=" + serverPort, payment);
        }
    }
}
