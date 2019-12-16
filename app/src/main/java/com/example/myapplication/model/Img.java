package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Img implements Serializable {

    @SerializedName("xs")
    @Expose
    private String xs;

    @SerializedName("sm")
    @Expose
    private String sm;

    @SerializedName("md")
    @Expose
    private String md;

    @SerializedName("lg")
    @Expose
    private String lg;



    public String getXs() {
        return xs;
    }

    public String getSm() {
        return sm;
    }

    public String getMd() {
        return md;
    }

    public String getLg() { return lg; }

    public void setXs(String xs) {
        this.xs = xs;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public void setMd(String md) {
        this.md = md;
    }
    public void setLg(String lg) {
        this.lg = lg;
    }
}