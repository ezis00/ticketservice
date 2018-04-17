package com.example.ticketservice.service.push;

import com.example.ticketservice.domain.valueobject.ChannelType;
import com.example.ticketservice.domain.valueobject.Message;

public class PCPush extends AbstractPush
{
    private final static ChannelType CHANNEL_TYPE = ChannelType.PC;

    @Override
    public ChannelType getChannelType()
    {
        return CHANNEL_TYPE;
    }
    @Override
    public void push(Message message)
    {
        System.out.println("pc push");
    }
}
