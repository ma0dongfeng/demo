package com.example.demo.connection;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;

public interface Session {

    /**
     * 下发数据
     */
    boolean flushOrWait(JSONObject issueMsg);

    /**
     * 获取会话ID
     *
     * @return
     */
    String getSessionId();

    void setSessionId(String id);

    /**
     * 获取Context
     *
     * @return
     */
    ChannelHandlerContext getContext();

}

