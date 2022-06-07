package com.hezhi3f.service.impl;

import com.hezhi3f.entity.Payment;
import com.hezhi3f.mapper.PaymentMapper;
import com.hezhi3f.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper mapper;

    @Override
    public Integer save(Payment payment) {
        return mapper.save(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return mapper.getPaymentById(id);
    }
}
