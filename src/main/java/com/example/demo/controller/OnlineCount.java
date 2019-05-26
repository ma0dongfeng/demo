package com.example.demo.controller;

import com.example.demo.connection.ChannelHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class OnlineCount {

    /**
     * @return当前WebSocket连接数
     */
    @GetMapping(value = "/action/count")
    public int count(){
        return ChannelHolder.getInstance().getchannelMap().size();
    }

}
