package com.demo.admin.controller;

import com.demo.admin.pojo.dto.LoginDto;
import com.demo.admin.pojo.vo.SysUserVo;
import com.demo.admin.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * UserController
 *
 * @author ybtccc ,2019/3/21
 */
@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    Result login(@RequestBody LoginDto req){
        SysUserVo vo = new SysUserVo();
        vo.setToken(UUID.randomUUID().toString().replace("-",""));
        return Result.success(vo);
    }
}
