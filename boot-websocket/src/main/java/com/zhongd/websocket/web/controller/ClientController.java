package com.zhongd.websocket.web.controller;

import com.zhongd.websocket.client.RegisterCache;
import com.zhongd.websocket.client.dto.Client;
import entity.Result;
import exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author 谢仲东
 * @description
 * @since 23:07 星期一 2018/12/17
 */
@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/register")
    public Result register(@RequestParam(required = false) String clientId, HttpServletRequest request) {

        log.info("header -> {}", request.getHeader("User-Agent"));
        log.info("ip -> {}", request.getRemoteAddr());
        if (StringUtils.isEmpty(clientId)) {
            throw new ParamException();
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        RegisterCache.add(token, new Client(clientId, "游客-".concat(clientId)));
        return Result.success(token);
    }

}
