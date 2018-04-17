package com.example.ticketservice.domain;

import java.util.UUID;

public class Knowledge extends Entity
{
    private String contents;

    public Knowledge(String contents)
    {
        super(UUID.randomUUID().toString());
        this.contents = contents;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    @Override
    public String toString()
    {
        return "Knowledge{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
