package com.example.demo.connection;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelHolder {

    private Map<Channel, String> channelMap;

    private static final ChannelHolder holder = new ChannelHolder();

    private ChannelHolder() {
        channelMap = new ConcurrentHashMap<>();
    }

    public static final ChannelHolder getInstance() {
        return holder;
    }

    public void addChannel(Channel channel, String clientId) {
        channelMap.put(channel,clientId);
    }

    public String getClientId(Channel channel) {
        return channelMap.get(channel);
    }

    public void removeChannel(Channel channel) {
        channelMap.remove(channel);
    }

    public Map<Channel, String> getchannelMap() {
        return channelMap;
    }

    public Set<Map.Entry<Channel, String>> getConnEntrySet() {
        return channelMap.entrySet();
    }

}
