package com.example.demo.command.commands;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.command.CommandHandler;
import com.example.demo.connection.ConnectionHolder;
import com.example.demo.connection.Session;
import com.example.demo.dao.MsgDao;
import com.example.demo.domain.MsgDO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QSTHandler implements CommandHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MsgDao msgDao;

    @Override
    public void handle(ChannelHandlerContext ctx, JSONObject recJson) throws Exception {
        String msg = recJson.getString("msg");
        String sid = recJson.getString("sid");
        Session session = ConnectionHolder.getInstance().getConn(sid);
        TextWebSocketFrame textWebSocketFrame = new TextWebSocketFrame(ctx.channel().id() + ":" + msg);
        TextWebSocketFrame textWebSocketFrame2 = new TextWebSocketFrame(ctx.channel().id() + ":" + msg);

        if(session!=null){
            ctx.writeAndFlush(textWebSocketFrame);
            session.getContext().writeAndFlush(textWebSocketFrame2);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        MsgDO msgDO = new MsgDO();
        msgDO.setCid(111L);
        msgDO.setMsg(msg);
        msgDO.setMsgId(1111L);
        msgDO.setMsgTime(date);
        msgDO.setMsgType("g");//对应不同的身份
        msgDO.setTalkId(11111L);
        msgDao.save(msgDO);
    }
}
