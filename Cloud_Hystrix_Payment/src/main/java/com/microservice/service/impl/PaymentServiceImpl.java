package com.microservice.service.impl;

import cn.hutool.core.util.IdUtil;
import com.microservice.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOk(Long id) {
        return "线程池 " + Thread.currentThread().getName() + " paymentInfoOk ,id: " + id + "\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String paymentInfoTimeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 " + Thread.currentThread().getName() + " paymentInfoTimeout ,id: " + id + "\t";
    }

    public String paymentInfoTimeoutHandler(Long id) {
        return "线程池 " + Thread.currentThread().getName() + " paymentInfoTimeoutHandler ,id: " + id + "\t" + "fallback策略";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),    //是否开启断路器（熔断）
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率

    })
    public String paymentCircuitBreaker(Long id){
        if (id < 0){
            throw new RuntimeException("参数不能小于0");
        }else {
            String serial = IdUtil.simpleUUID();
            return Thread.currentThread().getName() + "\t" + "调用成功，流水号 " + serial;
        }
    }

    public String paymentCircuitBreakerFallback(Long id){
        return "id不能为负";
    }


}
