package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HeroesModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("images")
    @Expose
    private Img image;

    @SerializedName("powerstats")
    @Expose
    private Powerstats powerstats;

    @SerializedName("biography")
    @Expose
    private Biography biography;

    public Biography getBiography() {
        return biography;
    }

    public Powerstats getPowerstats() {
        return powerstats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
