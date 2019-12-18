package com.example.myapplication;

import android.support.multidex.MultiDexApplication;

import com.example.myapplication.networks.ApiRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends MultiDexApplication {

    private static MyApplication instance;
    private static Retrofit retrofit;
    private static ApiRequest mApi;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        getRetrofitInstance();
    }

    /**
     * Get the retrofit instance.
     */
    private void getRetrofitInstance() {
        String BASE_URL = "https://akabab.github.io/superhero-api/api/";

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        mApi = retrofit.create(ApiRequest.class);
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static ApiRequest getApi(){
        return mApi;
    }
}
