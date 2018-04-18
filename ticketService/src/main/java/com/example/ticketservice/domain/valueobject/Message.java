package com.example.ticketservice.domain.valueobject;

public class Message
{
    private String contents;
    private String datetime;
    private MessageType messageType;

    public Message(String contents)
    {
        this(contents, System.currentTimeMillis());
    }

    public Message(String contents, String datetime)
    {
        this(contents, datetime, MessageType.TEXT);
    }

    public Message(String contents, String datetime, MessageType messageType)
    {
        this.contents = contents;
        this.datetime = datetime;
        this.messageType = messageType;
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
                ", messageType=" + messageType +
                '}';
    }
}
