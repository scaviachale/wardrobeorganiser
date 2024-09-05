package com.scaa.wardrobe.entities;

public class Cloth {
    public int imageId;
    String name, id, type, size, color, season;

    public Cloth(int imageId, String name, String id, String type, String size, String color, String season) {
        this.imageId = imageId;
        this.name = name;
        this.id = id;
        this.type = type;
        this.size = size;
        this.color = color;
        this.season = season;
    }
}
