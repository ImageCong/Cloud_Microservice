package com.microservice.controller;

import com.microservice.entities.CommonResult;
import com.microservice.entities.Payment;
import com.microservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        log.info("payment : ----------------- " +payment);
        int result = paymentService.create(payment);
        log.info("===============插入结果 : " + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入成功,serverPort : " + serverPort, result);
        } else {
            return new CommonResult<>(500, "插入失败", null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPatmentById(id);

        log.info("===============查询结果 : " + payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort : " + serverPort, payment);
        } else {
            return new CommonResult<>(500, "查询失败,查询ID为： " + id, null);
        }
    }

}