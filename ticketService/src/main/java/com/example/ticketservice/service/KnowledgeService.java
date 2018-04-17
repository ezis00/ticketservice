package com.example.ticketservice.service;

import java.util.List;

import com.example.ticketservice.domain.Knowledge;

public interface KnowledgeService
{
    void add(String contents);
    Knowledge get(String id);
    List<Knowledge> getAll();
}
