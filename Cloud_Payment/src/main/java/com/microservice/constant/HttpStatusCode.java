package com.microservice.constant;

/**
 * 常见状态码枚举类
 */
public enum HttpStatusCode {
    OK(200,"200 OK"),
    Created(201,"201 Created"),
    Accepted(202,"202 Accepted"),
    Multiple_Choices(300,"300 Multiple Choices"),
    Move_Temporarily(302,"302 Move Temporarily"),
    NOT_Modified(304,"304 Not Modified"),
    Forbidden(403,"403 Forbidden"),
    Bad_Request(400,"400 Bad Request"),
    NOT_FOUND(404,"404 NOT FOUND"),
    Method_Not_Allowed(405,"405 Method Not Allowed"),
    Internal_Server_Error(500," 500 Internal Server Error"),
    Bad_Gateway(502,"502 Bad Gateway");

    private Integer code;
    private String msg;

    // 构造方法不能为public，因为enum并不可以被实例化
    private HttpStatusCode(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    //不需要定义set方法，防止修改
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
