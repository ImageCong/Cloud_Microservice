package com.microservice.controller;

import com.microservice.client.PaymentFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentInfoTimeoutHandler")
public class OrderHystrixController {
    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id) {
        return paymentFeignClient.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })
    public String paymentInfoTimeout(@PathVariable("id") Long id) {
        return paymentFeignClient.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutHandler(Long id) {
        return "order端fallback策略";
    }

}
