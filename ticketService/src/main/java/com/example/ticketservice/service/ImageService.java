package com.example.ticketservice.service;

import com.example.ticketservice.domain.entity.Image;

public interface ImageService
{
    String upload(Image image);
    Image download(String path);
}
