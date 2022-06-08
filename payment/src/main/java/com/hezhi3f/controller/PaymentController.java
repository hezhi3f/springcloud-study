package com.hezhi3f.controller;

import com.hezhi3f.entity.Payment;
import com.hezhi3f.result.Result;
import com.hezhi3f.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Result discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("********************" + service + "********************");
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("instance.getInstanceId() = " + instance.getInstanceId());
                System.out.println("instance.getHost() = " + instance.getHost());
                System.out.println("instance.getMetadata() = " + instance.getMetadata());
                System.out.println("instance.getPort() = " + instance.getPort());
                System.out.println("instance.getScheme() = " + instance.getScheme());
                System.out.println("instance.getServiceId() = " + instance.getServiceId());
                System.out.println("instance.getUri() = " + instance.getUri());
            }
        }
        return Result.success(services);
    }
}
