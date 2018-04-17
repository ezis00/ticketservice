package com.example.ticketservice.domain.valueobject;

public class User
{
    private UserType type;
    private String name;
    private ChannelType channelType;

    public User(UserType type, String name, ChannelType channelType)
    {
        this.type = type;
        this.name = name;
        this.channelType = channelType;
    }

    public UserType getType()
    {
        return type;
    }

    public void setType(UserType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ChannelType getChannelType()
    {
        return channelType;
    }

    public void setChannelType(ChannelType channelType)
    {
        this.channelType = channelType;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", channelType=" + channelType +
                '}';
    }
}
