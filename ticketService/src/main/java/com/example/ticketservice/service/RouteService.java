package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public interface RouteService
{
    void route(List<Ticket> tickets, List<User> agents);
}
