package com.example.myapplication.data.api.model;

public class HeroInfo {

    private String name;
    private String powerstats; // TODO maybe change in array (use serializedName)
    private String biography;
    private String appearance;
    private String work;
    private ImageLinks image;

    public String getName() {
        return name;
    }

    public String getPowerstats() {
        return powerstats;
    }

    public String getBiography() {
        return biography;
    }

    public String getAppearance() {
        return appearance;
    }

    public String getWork() {
        return work;
    }

    public ImageLinks getImage() {
        return image;
    }
}
