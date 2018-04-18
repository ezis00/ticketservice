package com.example.ticketservice.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.ticketservice.domain.entity.Image;
import com.example.ticketservice.domain.entity.Ticket;
import com.example.ticketservice.domain.valueobject.Agent;
import com.example.ticketservice.domain.valueobject.ChannelType;
import com.example.ticketservice.domain.valueobject.Message;
import com.example.ticketservice.domain.valueobject.MessageType;
import com.example.ticketservice.domain.valueobject.User;
import com.example.ticketservice.domain.valueobject.UserType;
import com.example.ticketservice.service.AccountService;
import com.example.ticketservice.service.AccountServiceImpl;
import com.example.ticketservice.service.AdminService;
import com.example.ticketservice.service.AdminServiceImpl;
import com.example.ticketservice.service.ImageService;
import com.example.ticketservice.service.ImageServiceImpl;
import com.example.ticketservice.service.KnowledgeService;
import com.example.ticketservice.service.KnowledgeServiceImpl;
import com.example.ticketservice.service.ManageService;
import com.example.ticketservice.service.ManageServiceImpl;
import com.example.ticketservice.service.RouteService;
import com.example.ticketservice.service.RouteServiceImpl;
import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.service.TicketServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class TicketTest
{
    private final int MAX_CUSTOMER = 10;
    private final int MAX_AGENTS = 5;

    private final TicketService ticketService = new TicketServiceImpl();
    private final RouteService routeService = new RouteServiceImpl();
    private final ImageService imageService = new ImageServiceImpl();
    private final KnowledgeService knowledgeService = new KnowledgeServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();
    private final ManageService manageService = new ManageServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    @Before
    public void setup(){
        routeService.setTicketService(ticketService);
        manageService.setTicketService(ticketService);
        adminService.setAccountService(accountService);
    }

    @Test
    public void test()
    {
        initKnowledge();

        talkStart();

        List<Agent> agents = agentLogin();

        for (Agent agent : agents)
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

    @Test
    public void adminTest(){
        adminService.notify(new Message("goon night"));
    }

    @Test
    public void manageTest(){
        manageService.changeQueueSize(100);
    }

    private void talkStart()
    {
        List<ChannelType> channelTypes = Arrays.asList(ChannelType.PC, ChannelType.ANDROID, ChannelType.IOS, ChannelType.KAKAO);
        for (int i = 0; i < MAX_CUSTOMER; i++)
        {
            User customer = new User(UserType.CUSTOMER, "customer" + i, channelTypes.get(i % channelTypes.size()));
            System.out.println("talkStart " + customer);
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

    private List<Agent> agentLogin()
    {
        List<Agent> agents = new ArrayList<>();
        for (int i = 1; i <= MAX_AGENTS; i++)
        {
            Agent agent = new Agent(UserType.AGENT, "agent" + i, ChannelType.PC);
            agent.setMaxTicketCount(i);
            System.out.println("login " + agent);
            agents.add(agent);
        }

        routeService.route(agents);
        return agents;
    }

    private void agentSend(Agent agent)
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

        System.out.println("receive by " + agent.getName());
        List<Ticket> receive = ticketService.receive(agent);
        for (Ticket ticket : receive)
        {
            System.out.println("receive ticket " + ticket.getId() + " for " + agent.getName());
            for (Message message : ticket.getMessages())
            {
                System.out.println(message);
            }
        }
    }
}
