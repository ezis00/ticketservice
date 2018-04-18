package com.example.ticketservice.service;

import com.example.ticketservice.domain.valueobject.Message;

public interface AdminService
{
    void setAccountService(AccountService accountService);
    void notify(Message message);
}
