package com.microservice.service.impl;

import com.microservice.entities.Payment;
import com.microservice.mapper.PaymentMapper;
import com.microservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPatmentById(Long id) {
        return paymentMapper.getPatmentById(id);
    }

    @Override
    public List<Payment> list() {
        return paymentMapper.list();
    }
}
