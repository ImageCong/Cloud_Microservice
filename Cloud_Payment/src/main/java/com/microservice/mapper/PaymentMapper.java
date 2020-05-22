package com.microservice.mapper;

import com.microservice.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    /**
     * 新值
     */
    int create(Payment payment);

    /**
     * 根据id查找
     */
    Payment getPatmentById(@Param("id") Long id);

    /**
     * 列出所有
     */
    List<Payment> list();

}
