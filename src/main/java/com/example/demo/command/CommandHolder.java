package com.example.demo.command;

import com.example.demo.command.commands.QSTHandler;
import com.example.demo.command.commands.LGNHandler;

import java.util.HashMap;
import java.util.Map;

public class CommandHolder {

    private static Map<String, CommandHandler> COMMANDS = new HashMap<String, CommandHandler>();

    static {
        COMMANDS.put("QST", new QSTHandler());//上发
        COMMANDS.put("LGN", new LGNHandler());//客户端登录
    }

    public static CommandHandler getHandler(String cmd) {
        return COMMANDS.get(cmd);
    }

}
