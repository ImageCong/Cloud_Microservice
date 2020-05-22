package com.microservice.controller;

import com.microservice.entities.CommonResult;
import com.microservice.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private String PAYMENT_SERVICE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        // 向对应URL发送POST请求，请求得到CommonResult类型的response body
        // payment对应方法中的request参数，表示将payment作为request body封装到请求中
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/payment/get/" + id, CommonResult.class);
    }

}
