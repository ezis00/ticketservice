package com.example.ticketservice.service.push;

import com.example.ticketservice.domain.valueobject.ChannelType;
import com.example.ticketservice.domain.valueobject.Message;

public abstract class AbstractPush
{
    public abstract ChannelType getChannelType();
    public abstract void push(Message message);
}
