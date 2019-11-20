package com.example.myapplication.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.model.entity.HeroEntity;

@Database(entities = {HeroEntity.class}, version = 1)
public abstract class HeroDatabase extends RoomDatabase {

    public abstract HeroDao heroDao();
}
