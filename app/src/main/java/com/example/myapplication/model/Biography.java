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

    @SerializedName("publisher")
    @Expose
    private String publisher;

    public String getFullName() {
        return fullName;
    }

    public String getPublisher() {
        return publisher;
    }
}
