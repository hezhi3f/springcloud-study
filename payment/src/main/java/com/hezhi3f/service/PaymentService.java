package com.hezhi3f.service;

import com.hezhi3f.entity.Payment;

public interface PaymentService {
    Integer save(Payment payment);

    Payment getPaymentById(Integer id);
}
