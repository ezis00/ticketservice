package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.Ticket;
import com.example.ticketservice.domain.User;

public class RouteServiceImpl implements RouteService
{
    @Override
    public void route(List<Ticket> tickets, List<User> agents)
    {
        int agentSize = agents.size();
        for (int i = 0; i < tickets.size(); i++)
        {
            Ticket ticket = tickets.get(i);
            User agent = agents.get(i % agentSize);
            System.out.println("route " + ticket.getId() + " -> " + agent.getName());
            ticket.addUser(agent);
        }
    }
}
