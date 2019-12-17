package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents different links for the picture of the hero.
 */
public class Img {

    @SerializedName("sm")
    @Expose
    private String sm;

    @SerializedName("md")
    @Expose
    private String md;

    @SerializedName("xs")
    @Expose
    private String xs;
    
    @SerializedName("lg")
    @Expose
    private String lg;

    public String getXs() {
        return xs;
    }

    public String getMd() {
        return md;
    }

    public String getSm() {
        return sm;
    }

    public String getLg() {
        return lg;
    }
}
