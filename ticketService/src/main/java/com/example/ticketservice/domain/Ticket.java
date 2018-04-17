package com.example.ticketservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket extends Entity
{

    private List<Message> messages;
    private List<User> users;

    public Ticket(String id)
    {
        super(id);
        this.messages = new ArrayList<Message>();
        this.users = new ArrayList<User>();
    }

    public Ticket()
    {
        this(UUID.randomUUID().toString());
    }

    public void addMessage(Message message)
    {
        this.messages.add(message);
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    public void addUser(User user)
    {
        this.users.add(user);
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    @Override
    public String toString()
    {
        return "Ticket{" +
                "messages=" + messages +
                ", users=" + users +
                '}';
    }

    public String toStringWithId()
    {
        return "Ticket{" +
                "id=" + id +
                ", messages=" + messages +
                ", users=" + users +
                '}';
    }

    public static void main(String[] agrs)
    {
        Ticket ticket = new Ticket();
        System.out.println(ticket.toStringWithId());
        ticket.getMessages().add(new Message("hello", System.currentTimeMillis()));
        ticket.getUsers().add(new User(UserType.AGENT, "agent1"));
        ticket.getUsers().add(new User(UserType.CUSTOMER, "customer1"));
        ticket.getMessages().add(new Message("hello", System.currentTimeMillis()));
        System.out.println(ticket);
    }
}
