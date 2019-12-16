package com.example.myapplication.network;

import com.example.myapplication.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("all.json")
    Call<List<Hero>> getHeroesJson();
}
