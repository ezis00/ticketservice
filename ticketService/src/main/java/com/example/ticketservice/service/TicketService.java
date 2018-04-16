package com.example.ticketservice.service;

import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public interface TicketService
{
    void send(Ticket ticket, String message);
    Ticket receive(String ticketId);

    Ticket start(User customer);

    Ticket start(User agent, String ticketId);
}
