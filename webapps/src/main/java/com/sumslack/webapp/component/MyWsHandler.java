package com.sumslack.webapp.component;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class MyWsHandler extends AbstractWebSocketHandler {
    public static final ConcurrentHashMap<String,WebSocketSession> sessions = new ConcurrentHashMap<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("ws connected.");
        sessions.put(session.getId(),session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        session.sendMessage(new TextMessage(payload));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        session.sendMessage(new TextMessage(JSONUtil.toJsonStr(message)));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("WS ERROR");
        removeAndClose(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("WS DISCONN");
        removeAndClose(session.getId());
    }

    private void removeAndClose(String sessId){
        WebSocketSession sess = sessions.get(sessId);
        if(sess!=null){
            try{
                sess.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            sessions.remove(sessId);
        }
    }
}
