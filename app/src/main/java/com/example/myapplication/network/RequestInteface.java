package com.example.myapplication.network;

import com.example.myapplication.model.HeroesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Navneet Krishna on 11/05/19.
 */
public interface RequestInteface {

    @GET("all.json")
    Call<List<HeroesModel>> getHeroesJson();
}
