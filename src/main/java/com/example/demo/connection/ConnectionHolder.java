package com.example.demo.connection;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 存储连接相关的上下文
 */
public class ConnectionHolder {


    private Map<String, Session> connMap;

    private static final ConnectionHolder holder = new ConnectionHolder();

    private ConnectionHolder() {
        connMap = new ConcurrentHashMap<>();
    }

    public static final ConnectionHolder getInstance() {
        return holder;
    }

    public void addConn(String connectionId, Session session) {
        connMap.put(connectionId, session);
    }

    public Session getConn(String connectionId) {
        return connMap.get(connectionId);
    }

    public void removeConn(String connectionId) {
        connMap.remove(connectionId);
    }

    public Map<String, Session> getConnMap() {
        return connMap;
    }

    public Set<Map.Entry<String, Session>> getConnEntrySet() {
        return connMap.entrySet();
    }


    /**
     * 判断两个connectID是否为同一个访客
     *
     * @param source
     * @param dest
     * @return
     */
    public boolean compare(String source, String dest) {
        String a[] = source.split("\\$");
        String b[] = dest.split("\\$");
        if ("ACC".equals(b[2])) {
            return false;
        }
        return a.length == 4 && b.length == 4 && a[1].equals(b[1]);
    }
}
