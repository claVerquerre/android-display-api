package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hero implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("powerstats")
    private String powerstats;

    @SerializedName("biography")
    private String biography;

    @SerializedName("appearance")
    private String appearance;

    @SerializedName("work")
    private String work;

    @SerializedName("image")
    private String image;

    public Hero() { }

    public Hero(String id, String name, String powerstats, String biography, String appearance, String work, String image) {
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

    public String getImage() {
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

    public void setImage(String image) {
        this.image = image;
    }
}
