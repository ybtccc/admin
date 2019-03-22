package com.demo.admin.pojo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginDto
 *
 * @author ybtccc ,2019/3/22
 */
public class LoginDto {
    private static Logger logger = LoggerFactory.getLogger(LoginDto.class);

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
