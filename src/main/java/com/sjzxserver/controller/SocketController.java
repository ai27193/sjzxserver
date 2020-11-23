package com.sjzxserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjzxserver.service.WebSocketServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    @GetMapping("/webSocket")
    @ResponseBody
    public JSONObject socket() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success","true");
        webSocketServer.sendInfo("sjzx","abc");
        return jsonObject;
    }

    /**
     * 语音控制
     * @param
     * @return
     */
    @RequestMapping(value  = "/voice", method = RequestMethod.POST)
    @ResponseBody
    public String voice(@RequestBody Object data) {
        JSONObject jsonObject = new JSONObject();
        String model = data.toString();
        webSocketServer.sendInfo("sjzx",model);
        jsonObject.put("success","true");
        jsonObject.put("msg",model);
        return jsonObject.toString();
    }

    /**
     * 手势操作
     *
     * @return
     */
    @RequestMapping(value  = "/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request) {
        String message = null;
        JSONObject j = new JSONObject();
        String token  =  request.getParameter("SHBS");
        String cmd = request.getParameter("CMD");
        if("1".equals(cmd)) { //上翻
            webSocketServer.sendInfo("sjzx","11");
            message = "上翻成功";
        }else if("o".equals(cmd)) { //下翻
            webSocketServer.sendInfo("sjzx","10");
            message = "下翻成功";
        }
        j.put("success","true");
        j.put("msg",message);
        return j;
    }

    /**
     * 手势操作
     *
     * @return
     */
    @RequestMapping(value  = "action")
    @ResponseBody
    public JSONObject action(HttpServletRequest request) {
        String message = null;
        JSONObject j = new JSONObject();
        String token  =  request.getParameter("SHBS");
        String cmd = request.getParameter("CMD");
        if("1".equals(cmd)) { //上翻
            webSocketServer.sendInfo("sjzx","21");
            message = "上翻成功";
        }else if("2".equals(cmd)) { //下翻
            webSocketServer.sendInfo("sjzx","22");
            message = "下翻成功";
        }else if("3".equals(cmd)) { //左翻
            webSocketServer.sendInfo("sjzx","23");
            message = "左翻成功";
        }else if("4".equals(cmd)) { //右翻
            webSocketServer.sendInfo("sjzx","24");
            message = "右翻成功";
        }else if("5".equals(cmd)) { //播放
            webSocketServer.sendInfo("sjzx","25");
            message = "播放成功";
        }else if("6".equals(cmd)) { //停止
            webSocketServer.sendInfo("sjzx","26");
            message = "停止成功";
        }
        j.put("success","true");
        j.put("msg",message);
        return j;
    }
}