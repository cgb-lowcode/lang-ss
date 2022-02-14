package com.sumslack.webapp.service;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONUtil;
import com.sumslack.webapp.component.MyWsHandler;
import com.sumslack.webapp.conf.WebSocketConfig;
import com.sumslack.webapp.vo.PrintVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
@Slf4j
public class WsService {

    private void send(WebSocketSession session, String text) {
        try {
            session.sendMessage(new TextMessage(text));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void boardcast(String text){
        for(WebSocketSession session : MyWsHandler.sessions.values()){
            send(session,text);
        }
    }

    public void boardcast(String text,String tag){
        PrintVO vo = new PrintVO();
        vo.setTag(tag);
        vo.setMsg(text);
        for(WebSocketSession session : MyWsHandler.sessions.values()){
            send(session, JSONUtil.toJsonStr(vo));
        }
    }
}
