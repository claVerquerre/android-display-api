package com.example.myapplication.data.api;

import com.example.myapplication.data.api.model.Hero;
import com.example.myapplication.data.api.model.Heroes;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HeroDisplayService {

    @GET("heroes")
    Single<Heroes> getAllHeroes(@Query("key") String apiKey);

    @GET("heroes/{heroId}")
    Single<Hero> getHero(@Path("heroId") String heroId, @Query("key") String apiKey);
}
