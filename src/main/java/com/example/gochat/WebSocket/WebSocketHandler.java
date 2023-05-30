package com.example.gochat.WebSocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 在建立连接后的处理逻辑
        System.out.println("WebSocket连接已建立 当前用户: " + session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        // 解析消息类型
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(payload);
        String messageType = jsonNode.get("type").asText();

        if ("chat".equals(messageType)) {
            // 处理聊天消息
            handleChatMessage(session, jsonNode);
        } else if ("addFriend".equals(messageType)) {
            // 处理添加好友请求
            handleAddFriendRequest(session, jsonNode);
        } else {
            // 处理其他类型的消息
            handleOtherMessageType(session, jsonNode);
        }
    }

    private void handleChatMessage(WebSocketSession session, JsonNode jsonNode) {
        // 处理聊天消息的逻辑
        // ...
    }

    private void handleAddFriendRequest(WebSocketSession session, JsonNode jsonNode) {
        // 处理添加好友请求的逻辑
        // ...
    }

    private void handleOtherMessageType(WebSocketSession session, JsonNode jsonNode) {
        // 处理其他类型消息的逻辑
        // ...
    }

}

