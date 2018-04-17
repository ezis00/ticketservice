package com.example.ticketservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.ticketservice.domain.Message;
import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public class TicketServiceImpl implements TicketService
{
    private Map<String, Ticket> tickets;

    public TicketServiceImpl()
    {
        this.tickets = new HashMap<>();
    }

    @Override
    public Ticket start(User customer)
    {
        Ticket ticket = new Ticket();
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public void send(Ticket ticket, String message)
    {
        send(ticket, new Message(message, System.currentTimeMillis()));
    }

    @Override
    public void send(Ticket ticket, Message message)
    {
        ticket.addMessage(message);
        tickets.put(ticket.getId(), ticket);
    }

    @Override
    public List<Ticket> receive(User user)
    {
        return tickets.values().stream().filter(ticket -> ticket.getUsers().contains(user)).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getTickets()
    {
        return new ArrayList<Ticket>(this.tickets.values());
    }
}
