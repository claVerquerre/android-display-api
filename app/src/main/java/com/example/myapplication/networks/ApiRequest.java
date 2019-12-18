package com.example.myapplication.networks;

import com.example.myapplication.model.HeroesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("all.json")
    Call<List<HeroesModel>> getHeroes();
}
