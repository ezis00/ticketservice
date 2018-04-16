package com.example.ticketservice.domain;

public class Message
{
    private String contents;
    private String datetime;

    public Message(String contents, String datetime)
    {
        this.contents = contents;
        this.datetime = datetime;
    }

    public Message(String contents, long datetime)
    {
        this(contents, Long.toString(datetime));
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public String getDatetime()
    {
        return datetime;
    }

    public void setDatetime(String datetime)
    {
        this.datetime = datetime;
    }

    @Override
    public String toString()
    {
        return "Message{" +
                "contents='" + contents + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
