package com.zhongd.bootapi.web.controller;

import com.zhongd.bootapi.web.aspect.signature.SignRequest;
import com.zhongd.bootapi.dto.request.QueryParam;
import com.zhongd.bootapi.dto.response.QueryResponse;
import com.zhongd.bootapi.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import entity.BaseRequest;
import entity.BaseResponse;

import java.util.Arrays;

/**
 * @author 谢仲东 2018-12-05 9:59
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    @Autowired
    private RetryService retryService;

    @PostMapping("/query")
    @SignRequest
    public BaseResponse<QueryResponse> query(@RequestBody BaseRequest<QueryParam> request) {
        log.info("收到请求 >>> {}", request);

        QueryResponse response = new QueryResponse();
        response.setDataList(Arrays.asList(new String[] {"结果1", "结果2"}));
        response.setRemark("备注信息哦！");

        return BaseResponse.success(response);
    }


    @GetMapping("/retry")
    public String retry(String msg) {
        log.info("接口来了-");
        try {
            retryService.retryM(msg);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return "success";
    }
}
