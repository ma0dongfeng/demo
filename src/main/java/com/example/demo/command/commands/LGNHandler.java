package com.example.demo.command.commands;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.command.CommandHandler;
import com.example.demo.connection.ChannelHolder;
import com.example.demo.connection.ConnectionHolder;
import com.example.demo.connection.impl.DefaultSession;
import com.example.demo.dao.MsgDao;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LGNHandler implements CommandHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MsgDao msgDao;

    @Override
    public void handle(ChannelHandlerContext ctx, JSONObject recJson) throws Exception {
        String cid = recJson.getString("cid");
//        String sessionId = ctx.channel().id().toString();
        ChannelHolder.getInstance().addChannel(ctx.channel(),cid);

        if(!ConnectionHolder.getInstance().getConnMap().containsKey(cid)){
            ConnectionHolder.getInstance().addConn(cid, new DefaultSession(cid,ctx));
        }

    }
}
