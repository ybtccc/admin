package com.demo.admin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BizException Created by ybtccc on 2019/1/6.
 */
public class BizException extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(BizException.class);

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }
}
