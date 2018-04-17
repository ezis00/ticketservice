package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.User;

public interface RouteService
{
    void route(List<Ticket> tickets, List<User> agents);
}
