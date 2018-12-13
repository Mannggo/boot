package com.zhongd.bootapi.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author 谢仲东 2018-12-11 15:50
 */
@Service
public class RetryService {

    /**
     * 重试机制：
     * value        充值执行条件
     * maxAttempts  最大重试次数
     * backoff      补偿机制（delay:延时xx毫秒重试， mumultiplier:两次重试之间的时间倍数）
     * @param msg
     * @throws Exception
     */
    @Retryable(value = {Exception.class}, maxAttempts = 5, backoff = @Backoff(delay = 2000L, multiplier = 5))
    public void retryM(String msg) throws Exception {
        System.out.println("abc");
        if ("error".equals(msg)) {
            throw new Exception("失败");
        }
    }
}
