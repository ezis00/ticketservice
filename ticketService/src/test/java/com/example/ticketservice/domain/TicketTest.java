package com.example.ticketservice.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.service.TicketServiceImpl;
import org.junit.Test;

public class TicketTest
{
    private final int MAX_CUSTOMER = 10;
    private final int MAX_AGENTS = 5;

    @Test
    public void test()
    {
        List<String> ticketIds = new ArrayList<String>();

        TicketService ticketService = new TicketServiceImpl();
        for (int i = 0; i < MAX_CUSTOMER; i++)
        {
            User customer = new User(UserType.CUSTOMER, "customer" + i);
            System.out.println("write " + customer.getName());
            Ticket ticket = ticketService.start(customer);
            ticketIds.add(ticket.getId());
            for (int j = 0; j < 5; j++)
            {
                ticketService.send(ticket, "test message" + j);
            }
        }

        for (int i = 1; i <= MAX_AGENTS; i++)
        {
            User agent = new User(UserType.AGENT, "agent" + i);
            agentSendTest(ticketService, agent, ticketIds.get(i * 2 - 2));
            agentSendTest(ticketService, agent, ticketIds.get(i * 2 - 1));
        }
    }

    private void agentSendTest(TicketService ticketService, User agent, String ticketId)
    {
        System.out.println("receive " + agent.getName());

        Ticket ticket = ticketService.start(agent, ticketId);
        for (Message message : ticket.getMessages())
        {
            System.out.println(message);
        }
        System.out.println("write " + agent.getName());
        for (int j = 0; j < 5; j++)
        {
            ticketService.send(ticket, "test message" + j);
        }
    }
}
