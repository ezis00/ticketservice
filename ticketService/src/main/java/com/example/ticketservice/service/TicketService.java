package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.valueobject.Message;
import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.User;

public interface TicketService
{
    void setQueueService(QueueService queueService);

    Ticket start(User customer);

    void send(Ticket ticket, String message);

    void send(Ticket ticket, Message message);

    List<Ticket> receive(User user);

    void apply(Ticket ticket);

    Ticket getNextTicket();

    void changeQueueSize(int size);
}
