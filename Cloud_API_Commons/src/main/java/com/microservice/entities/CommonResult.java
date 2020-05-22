package com.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用于向前端返回数据，封装状态码、消息、对象
 * @param <T> 封装对应的对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    // HTTP状态码
    private Integer code;
    // 消息
    private String message;
    // 数据
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
