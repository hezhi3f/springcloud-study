package com.hezhi3f.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String consul() {
        return "payment service server port:" + serverPort + "\t" + UUID.randomUUID();
    }
}
