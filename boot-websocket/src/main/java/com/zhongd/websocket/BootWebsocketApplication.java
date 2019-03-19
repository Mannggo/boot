package com.zhongd.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class BootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebsocketApplication.class, args);
    }

}

