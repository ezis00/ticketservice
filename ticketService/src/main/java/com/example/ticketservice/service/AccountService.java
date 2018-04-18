package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.valueobject.User;

public interface AccountService
{
    void login(User user);

    List<User> getList();
}
