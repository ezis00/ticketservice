package com.example.ticketservice.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.Message;
import com.example.ticketservice.domain.valueobject.User;

public class TicketServiceImpl implements TicketService
{
    private PushService pushService = new PushServiceImpl();
    private QueueService queueService;
    private Map<String, Ticket> tickets;

    public TicketServiceImpl()
    {
        this.tickets = new HashMap<>();
    }

    @Override
    public void setQueueService(QueueService queueService)
    {
        this.queueService = queueService;
    }

    @Override
    public Ticket start(User customer)
    {
        Ticket ticket = new Ticket();
        ticket.addUser(customer);
//        tickets.put(ticket.getId(), ticket);
        this.queueService.add(ticket);
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
        pushService.push(ticket, message);
    }

    @Override
    public List<Ticket> receive(User user)
    {
        return tickets.values().stream().filter(ticket -> ticket.getUsers().contains(user)).collect(Collectors.toList());
    }

    @Override
    public Ticket getNextTicket()
    {
        return this.queueService.poll();
    }

    @Override
    public void changeQueueSize(int size)
    {
        System.out.println("change queue size : " + size);
    }

    @Override
    public void apply(Ticket ticket)
    {
        System.out.println("apply " + ticket);
        tickets.put(ticket.getId(), ticket);
    }
}
