package com.example.myapplication.model.api.model;

import com.example.myapplication.model.Hero;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Heroes {

    @SerializedName("items")
    List<Hero> heroesList;

    int nb_items;

    public List<Hero> getHeroesList() {
        return heroesList;
    }

    public int getNb_items() {
        return nb_items;
    }
}