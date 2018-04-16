package com.example.ticketservice.domain;

public abstract class Entity
{
    final protected String id;

    protected Entity(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
}
