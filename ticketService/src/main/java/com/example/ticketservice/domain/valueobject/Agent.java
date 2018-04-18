package com.example.ticketservice.domain.valueobject;

public class Agent extends User
{
    private int maxTicketCount;

    public Agent(UserType type, String name, ChannelType channelType)
    {
        super(type, name, channelType);
        this.maxTicketCount = 5;
    }

    public int getMaxTicketCount()
    {
        return maxTicketCount;
    }

    public void setMaxTicketCount(int maxTicketCount)
    {
        this.maxTicketCount = maxTicketCount;
    }

    @Override
    public String toString()
    {
        return "Agent{" +
                "maxTicketCount=" + maxTicketCount +
                '}';
    }
}
