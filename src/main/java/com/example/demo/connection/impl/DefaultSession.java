package com.example.demo.connection.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.connection.Session;
import io.netty.channel.ChannelHandlerContext;

public class DefaultSession implements Session {

    private String sessionId;
    private ChannelHandlerContext context ;

    public DefaultSession(String sessionId, ChannelHandlerContext context) {
        this.sessionId = sessionId;
        this.context = context;
    }
    @Override
    public boolean flushOrWait(JSONObject issueMsg) {
         try{
             context.writeAndFlush(issueMsg);
         }catch (Exception e){
             return false;
         }
        return true;
    }


    @Override
    public String getSessionId() {
        return this.sessionId;
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sessionId= sessionId;
    }

    @Override
    public ChannelHandlerContext getContext() {
        return this.context;
    }

}
