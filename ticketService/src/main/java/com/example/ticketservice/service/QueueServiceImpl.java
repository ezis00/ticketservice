package com.example.ticketservice.service;

import java.util.LinkedList;
import java.util.Queue;

import com.example.ticketservice.domain.entity.Ticket;

public class QueueServiceImpl implements QueueService
{
    private Queue<Ticket> ticketQueue;

    public QueueServiceImpl()
    {
        this.ticketQueue = new LinkedList<>();
    }

    @Override
    public void add(Ticket ticket)
    {
        this.ticketQueue.add(ticket);
    }

    @Override
    public Ticket poll()
    {
        return this.ticketQueue.poll();
    }
}
