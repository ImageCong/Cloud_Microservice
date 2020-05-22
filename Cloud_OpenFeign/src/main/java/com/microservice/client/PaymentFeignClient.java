package com.microservice.client;

import com.microservice.entities.CommonResult;
import com.microservice.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {
    /**
     * 新值
     */
    @PostMapping("/payment/create")
    int create(Payment payment);

    /**
     * 根据id查找
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPatmentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String timeoutTest();
}
