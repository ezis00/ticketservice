package com.example.ticketservice.service.push;

import java.util.HashMap;
import java.util.Map;

import com.example.ticketservice.domain.valueobject.ChannelType;

public class PushFactory
{
    private static Map<ChannelType, AbstractPush> pushMap = new HashMap<>();

    static
    {
        for (AbstractPush abstractPush : new AbstractPush[]{new AndroidPush(), new IOSPush(), new KakaoPush(), new PCPush()})
        {
            pushMap.put(abstractPush.getChannelType(), abstractPush);
        }
    }

    public static AbstractPush get(ChannelType channelType)
    {
        return pushMap.get(channelType);
    }
}
