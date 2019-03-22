package com.demo.admin.pojo.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SysUserVo
 *
 * @author ybtccc ,2019/3/22
 */
public class SysUserVo {
    private static Logger logger = LoggerFactory.getLogger(SysUserVo.class);

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
