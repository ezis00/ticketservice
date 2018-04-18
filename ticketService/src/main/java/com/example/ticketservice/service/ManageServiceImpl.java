package com.example.ticketservice.service;

public class ManageServiceImpl implements ManageService
{
    private TicketService ticketService;

    @Override
    public void setTicketService(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @Override
    public void changeQueueSize(int size)
    {
        this.ticketService.changeQueueSize(size);
    }
}
