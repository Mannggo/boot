package com.zhongd.bootapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 谢仲东
 * @description
 * @since 16:08 星期日 2018/12/16
 */
@Service
@Slf4j
public class HService {

    private static AtomicInteger failCount = new AtomicInteger(1);

    @Autowired
    private RetryService retryService;

    @Async("retryAsyncPool")
    public void bb(String msg) {
        try {
            retryService.retryM(msg);
        } catch (Exception e) {
            log.warn("调不通！");
        }
    }
}
