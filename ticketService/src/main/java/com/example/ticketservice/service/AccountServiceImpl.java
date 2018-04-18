package com.example.ticketservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.ticketservice.domain.valueobject.User;

public class AccountServiceImpl implements AccountService
{
    private List<User> users = new ArrayList<>();

    @Override
    public void login(User user)
    {
        users.add(user);
    }

    @Override
    public List<User> getList()
    {
        return this.users;
    }
}
