package com.zhongd.websocket.client;

import com.zhongd.websocket.dto.MessageDTO;
import com.zhongd.websocket.web.socket.WebSocketEndpoint;
import lombok.extern.slf4j.Slf4j;
import util.GsonUtils;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Optional.ofNullable;

/**
 * @author 谢仲东
 * @date 2019/3/19 16:40
 */
@Slf4j
public class ConnectedClientCache {

    private static ConcurrentHashMap<String, WebSocketEndpoint> clientMap = new ConcurrentHashMap<>(100);

    public static void add(String id, WebSocketEndpoint endpoint) {
        clientMap.putIfAbsent(id, endpoint);
        log.info("{} connected, current count -> {}", id, clientMap.size());
    }

    public static void remove(String id) {
        clientMap.remove(id);
        log.info("{} disconnected, current count -> {}", id, clientMap.size());
    }

    public static void onMessage(String message) {
        ofNullable(GsonUtils.fromJSON(message, MessageDTO.class))
                .ifPresent(msg -> {

        });
    }
}
