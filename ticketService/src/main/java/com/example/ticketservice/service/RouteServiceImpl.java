package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.Agent;

public class RouteServiceImpl implements RouteService
{
    private TicketService ticketService;

    @Override
    public void setTicketService(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @Override
    public void route(List<Agent> agents)
    {
        for (Agent agent : agents)
        {
            for (int i = 0; i < agent.getMaxTicketCount(); i++)
            {
                Ticket ticket = ticketService.getNextTicket();
                if (ticket != null)
                {
                    System.out.println("route " + ticket.getId() + " -> " + agent.getName());
                    ticket.addUser(agent);
                    ticketService.apply(ticket);
                }
            }
        }
    }
}
