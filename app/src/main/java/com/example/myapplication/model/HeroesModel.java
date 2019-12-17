package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents an hero.
 */
public class HeroesModel {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("images")
    @Expose
    private Img image;

    @SerializedName("powerstats")
    @Expose
    private Powerstats powerstats;

    @SerializedName("work")
    @Expose
    private Work work;

    @SerializedName("appearance")
    @Expose
    private Appearance appearance;

    @SerializedName("biography")
    @Expose
    private Biography biography;

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Powerstats getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(Powerstats powerstats) {
        this.powerstats = powerstats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Img getImage() {
        return image;
    }

    public void setImage(Img image) {
        this.image = image;
    }
}
