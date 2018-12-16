package com.zhongd.bootapi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 谢仲东
 * @description
 * @since 15:51 星期日 2018/12/16
 */
@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Bean("retryAsyncPool")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(5); 这里的max不生效？？？？
        executor.setQueueCapacity(64);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("CallbackRetry-");

        return executor;
    }
}
