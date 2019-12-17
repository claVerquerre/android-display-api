package com.example.myapplication.network;

import com.example.myapplication.model.HeroesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The interface for the request calls.
 */
public interface RequestInteface {

    @GET("all.json")
    Call<List<HeroesModel>> getHeroesJson();
}
