package com.zhongd.bootapi.controller;

import com.zhongd.bootapi.dto.Result;
import com.zhongd.bootapi.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author 谢仲东 2018-12-05 9:59
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/query")
    public String query(@RequestParam String text) {
        log.info("bug ===>>>" + text);
        return "success";
    }

    @PostMapping("/save")
    public Result save(@RequestBody HashMap<String, Object> param) {
        log.info("bug2 ===>>>{}", param);
        Result r = new Result("成功", 0);
        return r;
    }

    @GetMapping("/retry")
    public Result retry(String msg) {
        log.info("接口来了-");
        try {
            apiService.retryM(msg);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return new Result("成功", 0);
    }
}
