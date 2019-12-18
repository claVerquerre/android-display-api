package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents the work of an hero.
 */
public class Work {

    @SerializedName("occupation")
    @Expose
    private String occupation;

    @SerializedName("base")
    @Expose
    private String base;

    public String getOccupation() {
        return occupation;
    }

    public String getBase() {
        return base;
    }
}
