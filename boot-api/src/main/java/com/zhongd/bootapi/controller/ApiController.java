package com.zhongd.bootapi.controller;

import com.zhongd.bootapi.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author 谢仲东 2018-12-05 9:59
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

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
}
