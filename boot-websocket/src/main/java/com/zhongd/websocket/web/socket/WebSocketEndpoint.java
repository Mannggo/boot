package com.zhongd.websocket.web.socket;

import com.zhongd.websocket.client.ConnectedClientCache;
import com.zhongd.websocket.client.RegisterCache;
import com.zhongd.websocket.client.dto.Client;
import com.zhongd.websocket.exception.SocketException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static java.util.Optional.ofNullable;

/**
 * @author 谢仲东
 * @date 2019/3/19 16:17
 */
@Component
@ServerEndpoint("/mySocket/{token}")
public class WebSocketEndpoint {

    private Client client;

    private Session session;

    @OnOpen
    public void onOpen(@PathParam("token") String token, Session session) {
        try {
            ofNullable(token).filter(t -> !StringUtils.isEmpty(t)).orElseThrow(() -> new SocketException("注册缺少token"));
            Client client = RegisterCache.get(token);
            if (client != null) {
                this.session = session;
                this.client = client;
                ConnectedClientCache.add(client.getId(), this);
                RegisterCache.remove(token);
            } else {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        if (this.client != null) {
            ConnectedClientCache.remove(this.client.getId());
        }
    }

    @OnError
    public void onError(Throwable throwable, Session session) {
//    	logger.error("Error occurs ! ", throwable);
    }

}
