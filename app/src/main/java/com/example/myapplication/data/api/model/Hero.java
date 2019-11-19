package com.example.myapplication.data.api.model;

public class Hero {

    private String id;
    private HeroInfo heroInfo;
    private boolean isFavorite;

    public String getId() {
        return this.id;
    }

    public HeroInfo getHeroInfo() {
        return this.heroInfo;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }
}
