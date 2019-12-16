package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hero implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("powerstats")
    @Expose
    private String powerstats;

    @SerializedName("biography")
    @Expose
    private String biography;

    @SerializedName("appearance")
    @Expose
    private String appearance;

    @SerializedName("work")
    @Expose
    private String work;

    @SerializedName("image")
    @Expose
    private Img image;

    public Hero() { }

    public Hero(String id, String name, String powerstats, String biography, String appearance, String work, Img image) {
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

    public Img getImage() {
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

    public void setImage(Img image) {
        this.image = image;
    }
}
