package com.microservice.service;

public interface PaymentService {
    String paymentInfoOk(Long id);

    String paymentInfoTimeout(Long id);

    String paymentCircuitBreaker(Long id);
}
