package com.example.ticketservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.ticketservice.domain.entity.Knowledge;

public class KnowledgeServiceImpl implements KnowledgeService
{
    private Map<String, Knowledge> knowledges = new HashMap<>();

    @Override
    public void add(String contents)
    {
        Knowledge knowledge = new Knowledge(contents);
        knowledges.put(knowledge.getId(), knowledge);
    }

    @Override
    public Knowledge get(String id)
    {
        return knowledges.get(id);
    }

    @Override
    public List<Knowledge> getAll()
    {
        return knowledges.values().stream().collect(Collectors.toList());
    }
}
