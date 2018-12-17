package com.zhongd.websocket.web.controller;

import constants.ExceptionMsg;
import entity.Result;
import exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * @author 谢仲东
 * @description
 * @since 23:07 星期一 2018/12/17
 */
@Slf4j
@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/register")
    public Result register(@RequestParam(required = false) String clientId) {
        if (StringUtils.isEmpty(clientId)) {
            throw new ParamException();
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        return Result.success(token);
    }

}
