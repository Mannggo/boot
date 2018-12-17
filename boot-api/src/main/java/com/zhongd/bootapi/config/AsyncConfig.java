package com.zhongd.bootapi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author 谢仲东
 * @description
 * @since 15:51 星期日 2018/12/16
 */
@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    /**
     * note: 线程池的参数配置
     *      1. corePoolSize 核心线程数
     *      2. maxPoolSize  最大线程数
     *      3. queueCapacity阻塞队列容量
     *
     *      当要执行的线程数n > 核心线程数c, 且阻塞队列容量为q, 最大线程数为m时，
     *      第c + 1到第 c + n个线程会进入阻塞队列，第c + n + 1 到 c + n + ( m - 1)个线程会开启新线程执行。
     * @return
     */
    @Bean("retryAsyncPool")
    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(2);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("CallbackRetry-");
        return executor;

//        return new ThreadPoolExecutor(1, 5,
//                2000L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(2));
    }
}
