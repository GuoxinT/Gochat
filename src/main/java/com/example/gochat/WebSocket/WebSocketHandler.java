package com.example.gochat.WebSocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 在建立连接后的处理逻辑
        System.out.println("WebSocket连接已建立");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理接收到的文本消息
        System.out.println("接收到消息：" + message.getPayload());

        // 发送回复消息给客户端
        session.sendMessage(new TextMessage("服务器收到消息：" + message.getPayload()));
    }
}

