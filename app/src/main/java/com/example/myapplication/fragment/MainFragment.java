package com.example.myapplication.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;
import com.example.myapplication.network.RequestInteface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class MainFragment extends AppCompatActivity {

    ArrayList<HeroesModel> heroesModels = new ArrayList<>();
    private HeroesAdapter heroesAdapter;
    private RecyclerView heroes_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroes_recyclerview = findViewById(R.id.heroes_recyclerview);
        heroes_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getHeroesResponse();
    }

    /**
     *
     */
    private void getHeroesResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://akabab.github.io/superhero-api/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInteface requestInteface = retrofit
                .create(RequestInteface.class);
        Call<List<HeroesModel>> call = requestInteface.getHeroesJson();

        call.enqueue(new Callback<List<HeroesModel>>() {
            @Override
            public void onResponse(Call<List<HeroesModel>> call, Response<List<HeroesModel>> response) {
                heroesModels = new ArrayList<>(response.body());
                heroesAdapter = new HeroesAdapter(heroesModels);
                heroes_recyclerview.setAdapter(heroesAdapter);
            }

            @Override
            public void onFailure(Call<List<HeroesModel>> call, Throwable t) {
                Toast.makeText(MainFragment.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
