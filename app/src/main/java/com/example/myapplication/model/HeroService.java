package com.example.myapplication.model;

import javax.inject.Inject;
import com.example.myapplication.di.DaggerApiComponent;

import java.util.List;

import io.reactivex.Single;
import com.example.myapplication.di.DaggerApiComponent;
public class HeroService {

    private static volatile HeroService instance;

    @Inject
    HeroApi api;

    private HeroService() {
        DaggerApiComponent.inject(this);
    }

    public static HeroService getInstance() {
        if (instance == null) {
            synchronized (HeroService.class) {
                if (instance == null) {
                    instance = new HeroService();
                }
            }
        }
        return instance;
    }

    public Single<List<Hero>> getHeroes() {
        return api.getHeroes();
    }
}
