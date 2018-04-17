package com.example.ticketservice.domain;

import java.util.UUID;

public class Image extends Entity
{
    private String image;

    public Image(String image)
    {
        super(UUID.randomUUID().toString());
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Image{" +
                "image='" + image + '\'' +
                '}';
    }
}
