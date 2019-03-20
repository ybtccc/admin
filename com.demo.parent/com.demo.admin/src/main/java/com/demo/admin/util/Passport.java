package com.demo.admin.util;

import java.io.Serializable;

/**
 * Passport
 *
 * @author ybtccc ,2019/2/27
 */
public class Passport implements Serializable {

    private static final long serialVersionUID = 1L;
    public static ThreadLocal<Passport> threadLocal = new ThreadLocal<>();

    private String requestBody;

    private String ip;

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
