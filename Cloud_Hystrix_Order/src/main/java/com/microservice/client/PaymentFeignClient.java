package com.microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFallback.class)
public interface PaymentFeignClient {
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id);
}
