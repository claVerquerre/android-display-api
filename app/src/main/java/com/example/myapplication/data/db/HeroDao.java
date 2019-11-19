package com.example.myapplication.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.data.entity.HeroEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface HeroDao {

    @Query("SELECT * from heroentity")
    Flowable<List<HeroEntity>> loadFavorites();

    @Insert
    public Completable addHeroToFavorites(HeroEntity heroEntity);

    @Query("DELETE FROM heroentity WHERE id = :id")
    public Completable deleteHeroToFavorites(String id);

    @Query("SELECT id FROM heroentity")
    Single<List<String>> getFavoriteIdList();
}
