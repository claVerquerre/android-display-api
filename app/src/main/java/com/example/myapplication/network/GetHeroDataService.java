package com.example.myapplication.network;

import com.example.myapplication.model.Hero;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetHeroDataService {

    @GET("{id}")
    Call<Hero> getHero(@Path("id") String id);
}
