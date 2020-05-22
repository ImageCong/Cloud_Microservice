package com.microservice.service;

import com.microservice.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    /**
     * 新值
     */
    int create(Payment payment);

    /**
     * 根据id查找
     */
    Payment getPatmentById(@Param("id") Long id);

    /**
     * 列出所有
     */
    List<Payment> list();
}
