package com.example.ticketservice.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.ticketservice.service.ImageService;
import com.example.ticketservice.service.ImageServiceImpl;
import com.example.ticketservice.service.KnowledgeService;
import com.example.ticketservice.service.KnowledgeServiceImpl;
import com.example.ticketservice.service.RouteService;
import com.example.ticketservice.service.RouteServiceImpl;
import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.service.TicketServiceImpl;
import org.junit.Test;

public class TicketTest
{
    private final int MAX_CUSTOMER = 10;
    private final int MAX_AGENTS = 5;
    private final TicketService ticketService = new TicketServiceImpl();
    private final ImageService imageService = new ImageServiceImpl();
    private final KnowledgeService knowledgeService = new KnowledgeServiceImpl();

    @Test
    public void test()
    {
        initKnowledge();

        talkStart();

        RouteService routeService = new RouteServiceImpl();

        List<User> agents = agentLogin();

        routeService.route(ticketService.getTickets(), agents);

        for (User agent : agents)
        {
            agentSend(agent);
        }
    }

    private void initKnowledge()
    {
        System.out.println("initKnowledge");
        knowledgeService.add("지식입니다1.");
        knowledgeService.add("지식입니다2.");
    }

    private void talkStart()
    {
        for (int i = 0; i < MAX_CUSTOMER; i++)
        {
            User customer = new User(UserType.CUSTOMER, "customer" + i);
            System.out.println("talkStart " + customer.getName());
            Ticket ticket = ticketService.start(customer);
            System.out.println("sendMessage " + customer.getName());
            for (int j = 0; j < 5; j++)
            {
                ticketService.send(ticket, "test message" + j + " by " + customer.getName());
            }
            String imageId = imageService.upload(new Image("image contents by " + customer.getName()));
            ticketService.send(ticket, new Message(imageId, Long.toString(System.currentTimeMillis()), MessageType.IMAGE));
        }
    }

    private List<User> agentLogin()
    {
        List<User> agents = new ArrayList<>();
        for (int i = 1; i <= MAX_AGENTS; i++)
        {
            User agent = new User(UserType.AGENT, "agent" + i);
            System.out.println("login " + agent);
            agents.add(agent);
        }
        return agents;
    }

    private void agentSend(User agent)
    {
        List<Ticket> tickets = ticketService.receive(agent);
        for (Ticket ticket : tickets)
        {
            System.out.println("receive ticket " + ticket.getId() + " for " + agent.getName());
            for (Message message : ticket.getMessages())
            {
                System.out.println(message);
            }
            System.out.println("sendMessage " + agent.getName());
            for (int j = 0; j < 5; j++)
            {
                ticketService.send(ticket, "test message" + j + " by " + agent.getName());
            }
            String imageId = imageService.upload(new Image("image contents by " + agent.getName()));
            ticketService.send(ticket, new Message(imageId, Long.toString(System.currentTimeMillis()), MessageType.IMAGE));
            ticketService.send(ticket, knowledgeService.getAll().get(0).getContents());
        }
    }
}
