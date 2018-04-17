package com.example.ticketservice.service;

import java.util.HashMap;
import java.util.Map;

import com.example.ticketservice.domain.Image;

public class ImageServiceImpl implements ImageService
{
    private Map<String, Image> images = new HashMap<>();

    @Override
    public String upload(Image image)
    {
        images.put(image.getId(), image);
        return image.getId();
    }

    @Override
    public Image download(String path)
    {
        return images.get(path);
    }
}
