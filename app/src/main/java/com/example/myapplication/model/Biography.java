package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents the biography of an hero.
 */
public class Biography {

    @SerializedName("fullName")
    @Expose
    private String fullName;

    @SerializedName("placeOfBirth")
    @Expose
    private String placeOfBirth;

    @SerializedName("firstAppearance")
    @Expose
    private String firstAppearance;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("alignment")
    @Expose
    private String alignment;

    public String getFullName() {
        return fullName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAlignment() {
        return alignment;
    }
}
