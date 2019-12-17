package com.example.myapplication;

import android.support.multidex.MultiDexApplication;

import com.example.myapplication.network.RequestInteface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TODO
 */
public class MyApplication extends MultiDexApplication {

    private static MyApplication instance;
    private static Retrofit retrofit;
    private static RequestInteface mApi;
    private static String BASE_URL = "https://akabab.github.io/superhero-api/api/";

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        getRetrofitInstance();
    }

    /**
     * TODO
     */
    private void getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        mApi = retrofit.create(RequestInteface.class);
    }

    public static RequestInteface getmApi() {
        return mApi;
    }
}
