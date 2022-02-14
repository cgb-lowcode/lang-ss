package com.sumslack.webapp.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import com.sumslack.webapp.common.Result;
import com.sumslack.webapp.service.WsService;
import com.sumslack.webapp.vo.PrintVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PushController {
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private WsService wsService;

    @PostMapping("/send-print")
    @ResponseBody
    public String sendPrint(@RequestBody PrintVO printVO){
        wsService.boardcast(JSONUtil.toJsonStr(printVO));
        return "success";
    }

//    @MessageMapping("/send")
//    @SendTo("/topic/coding")
//    public Result<?> say(String msg, String tag) {
//        Map ret = MapUtil.newHashMap();
//        ret.put("msg",msg);
//        ret.put("tag", Convert.toStr(tag,""));
//        return Result.ok(ret);
//    }

}
