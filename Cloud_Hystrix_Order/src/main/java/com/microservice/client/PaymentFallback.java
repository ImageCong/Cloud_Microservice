package com.microservice.client;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentFeignClient {
    @Override
    public String paymentInfoOk(Long id) {
        return "=======paymentInfoOk========fallback";
    }
    @Override
    public String paymentInfoTimeout(Long id) {
        return "=======paymentInfoTimeout========fallback";
    }
}
