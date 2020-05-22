package com.microservice.controller;

import com.microservice.entities.CommonResult;
import com.microservice.entities.Payment;
import com.microservice.client.PaymentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentFeignClient paymentFeignClient;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignClient.getPatmentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    String timeoutTest(){
        return paymentFeignClient.timeoutTest();
    }

}
