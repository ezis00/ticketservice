package com.example.ticketservice.service;

import com.example.ticketservice.domain.entity.Ticket;

public interface QueueService
{
    void add(Ticket ticket);

    Ticket poll();
}
