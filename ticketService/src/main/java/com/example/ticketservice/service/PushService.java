package com.example.ticketservice.service;

import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.Message;

public interface PushService
{
    void push(Ticket ticket, Message message);
}
