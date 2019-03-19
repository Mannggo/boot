package com.zhongd.websocket.client;

import com.zhongd.websocket.client.dto.Client;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谢仲东
 * @date 2019/3/19 16:20
 */
public class RegisterCache {

    public static ConcurrentHashMap<String, Client> registerMap = new ConcurrentHashMap<>(100);

    public static void add(String token, Client registerObj) {
        registerMap.putIfAbsent(token, registerObj);
    }

    public static Client get(String token) {
        return registerMap.get(token);
    }

    public static Client remove(String token) {
        return registerMap.remove(token);
    }
}
