package com.example.ticketservice.domain.valueobject;

public class User
{
    private UserType type;
    private String name;

    public User(UserType type, String name)
    {
        this.type = type;
        this.name = name;
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

    @Override
    public String toString()
    {
        return "User{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
