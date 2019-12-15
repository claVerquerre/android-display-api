package com.example.myapplication.di;

import com.example.myapplication.model.HeroApi;
import com.example.myapplication.model.HeroService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitInstance {

    private static final String BASE_URL = "https://akabab.github.io/superhero-api/api/";

    @Provides
    HeroApi provideHeroApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(HeroApi.class);
    }

    @Provides
    HeroService provideHeroService() {
        return HeroService.getInstance();
    }
}
