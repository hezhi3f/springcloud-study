package com.hezhi3f.mapper;

import com.hezhi3f.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {
    Integer save(Payment payment);

    Payment getPaymentById(Integer id);
}
