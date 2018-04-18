package com.example.ticketservice.service;

import com.example.ticketservice.domain.valueobject.Message;
import com.example.ticketservice.domain.valueobject.User;

public class AdminServiceImpl implements AdminService
{
    private AccountService accountService;

    @Override
    public void setAccountService(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @Override
    public void notify(Message message)
    {
        for (User user : this.accountService.getList())
        {
            System.out.println(message + " to " + user.getName());
        }
    }
}
