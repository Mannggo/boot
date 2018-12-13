package com.zhongd.bootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class BootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApiApplication.class, args);
    }
}
