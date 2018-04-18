package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.valueobject.Agent;

public interface RouteService
{
    void setTicketService(TicketService ticketService);
    void route(List<Agent> agents);
}
