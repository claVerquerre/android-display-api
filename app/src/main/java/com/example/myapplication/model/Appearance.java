package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents the appearance of an hero.
 */
public class Appearance {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("race")
    @Expose
    private String race;

    @SerializedName("eyeColor")
    @Expose
    private String eyeColor;

    @SerializedName("hairColor")
    @Expose
    private String hairColor;

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }
}
