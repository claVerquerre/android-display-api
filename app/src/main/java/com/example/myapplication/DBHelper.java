package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.model.HeroesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper of the DataBase (sqlite).
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelper;

    private static final String DATABASE_NAME = "my_heroes_db";
    private static final String TABLE_HEROES = "TABLE_HEROES";
    private static final String KEY_ID = "KEY_ID";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_URL = "KEY_URL";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static DBHelper getInstance(final Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HERO_TABLE = "CREATE TABLE "
                + TABLE_HEROES
                + "("
                + KEY_ID
                + " TEXT PRIMARY KEY,"
                + KEY_NAME
                + " TEXT,"
                + KEY_URL
                + " TEXT"
                + ")";
        db.execSQL(CREATE_HERO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HEROES);
        onCreate(db);
    }

    /**
     * Create all the tables needed (here just one)
     * @param sqLiteDatabase sqLite Database
     */
    private void createAllTables(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(TABLE_HEROES);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    /**
     * Add the heroes in the DataBase.
     * @param heroesModels list of heroes
     */
    public void addHeroes(List<HeroesModel> heroesModels) {

        final SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransactionNonExclusive();

        try {
            for (HeroesModel heroesModel : heroesModels) {

                ContentValues values = new ContentValues();
                values.put(KEY_NAME, heroesModel.getName());
                values.put(KEY_URL, heroesModel.getImage().getSm());

                db.insertWithOnConflict(TABLE_HEROES, null, values, SQLiteDatabase.CONFLICT_IGNORE);

                values.clear();
            }
            db.setTransactionSuccessful();
        }
        catch (SQLiteException e) {
            createAllTables(db);
        }
        finally {
            db.endTransaction();
        }
    }

    /**
     * Return the heroes created from the database.
     * @return list of heroes get from the database
     */
    public List<HeroesModel> getAllHeroes() {

        List<HeroesModel> heroesModelList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_HEROES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // cursor represents the position on the db when reading
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {
                HeroesModel hero = new HeroesModel();
                hero.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
                hero.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                hero.getImage().setSm(cursor.getString(cursor.getColumnIndex(KEY_URL)));

                // Add hero to list
                heroesModelList.add(hero);
            }
        }
        return heroesModelList;
    }
}


