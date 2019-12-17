package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents powerstats of an hero.
 */
public class Powerstats {

    @SerializedName("intelligence")
    @Expose
    private String intelligence;

    @SerializedName("strength")
    @Expose
    private String strength;

    @SerializedName("speed")
    @Expose
    private String speed;

    @SerializedName("durability")
    @Expose
    private String durability;

    @SerializedName("power")
    @Expose
    private String power;

    @SerializedName("combat")
    @Expose
    private String combat;

    public String getIntelligence() {
        return intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDurability() {
        return durability;
    }

    public String getPower() {
        return power;
    }

    public String getCombat() {
        return combat;
    }
}
