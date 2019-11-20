package com.example.myapplication.model;

import com.example.myapplication.model.api.model.ImageLinks;

public class Hero {

    private String id;
    private String name;
    private String powerstats;
    private String biography;
    private String appearance;
    private String work;
    private ImageLinks image;

    public Hero() {

    }

    public Hero(String id, String name, String powerstats, String biography, String appearance, String work, ImageLinks image) {
        this.id = id;
        this.name = name;
        this.powerstats = powerstats;
        this.biography = biography;
        this.appearance = appearance;
        this.work = work;
        this.image = image;
    }

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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerstats(String powerstats) {
        this.powerstats = powerstats;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setImage(ImageLinks image) {
        this.image = image;
    }
}
