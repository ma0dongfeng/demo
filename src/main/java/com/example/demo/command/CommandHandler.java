package com.example.demo.command;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;

public interface CommandHandler {
    void handle(ChannelHandlerContext ctx, JSONObject recJson) throws Exception;
}
