package com.example.ticketservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ticketservice.domain.Message;
import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public class TicketServiceImpl implements TicketService
{
    private Map<String, Ticket> tickets;

    public TicketServiceImpl()
    {
        this.tickets = new HashMap<String, Ticket>();
    }

    public Ticket start(User customer)
    {
        Ticket ticket = new Ticket();
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket start(User agent, String ticketId)
    {
        Ticket ticket = tickets.get(ticketId);
        ticket.getUsers().add(agent);
        return ticket;
    }

    public void send(Ticket ticket, String message)
    {
        ticket.getMessages().add(new Message(message, System.currentTimeMillis()));
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket receive(String ticketId)
    {
        return tickets.get(ticketId);
    }
}
