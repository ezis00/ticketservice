package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.Message;
import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public interface TicketService
{
    Ticket start(User customer);

    void send(Ticket ticket, String message);

    void send(Ticket ticket, Message message);

    List<Ticket> receive(User user);

    List<Ticket> getTickets();
}
