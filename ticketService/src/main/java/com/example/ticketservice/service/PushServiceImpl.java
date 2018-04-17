package com.example.ticketservice.service;

import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.Message;
import com.example.ticketservice.domain.valueobject.User;
import com.example.ticketservice.service.push.PushFactory;

public class PushServiceImpl implements PushService
{
    @Override
    public void push(Ticket ticket, Message message)
    {
        for (User user : ticket.getUsers())
        {
            PushFactory.get(user.getChannelType()).push(message);
        }
    }
}
