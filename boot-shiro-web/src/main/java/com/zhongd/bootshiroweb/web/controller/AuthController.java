package com.zhongd.bootshiroweb.web.controller;

import constants.ResultCode;
import entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权相关
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/nologin")
    public Result nologin() {
        Result result = new Result();
        result.setCode(ResultCode.LOGIN_ERROR.getCode());
        result.setMsg(ResultCode.LOGIN_ERROR.getDefaultMsg());
        return result;
    }
}
