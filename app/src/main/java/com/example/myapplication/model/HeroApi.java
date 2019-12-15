package com.example.myapplication.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface HeroApi {

    @GET("all.json")
    Single<List<Hero>> getHeroes();
}
