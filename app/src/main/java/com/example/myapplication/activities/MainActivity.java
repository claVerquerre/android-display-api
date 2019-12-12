package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.model.Hero;
import com.example.myapplication.network.GetHeroDataService;
import com.example.myapplication.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private List<Hero> heroList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        heroList = new ArrayList<>();

        dataRequest();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, heroList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     *
     */
    private void dataRequest() {

        /*for (int i=1; i<=100; i++){

            GetHeroDataService heroDataService = RetrofitInstance.getRetrofitInstance().create(GetHeroDataService.class);
            Call<Hero> call = heroDataService.getHero(String.valueOf(i));

            call.enqueue(new Callback<Hero>() {
                @Override
                public void onResponse(Call<Hero> call, Response<Hero> response) {
                    Hero hero = response.body();
                    heroList.add(hero);
                }

                @Override
                public void onFailure(Call<Hero> call, Throwable t) {
                    Toast.makeText(MainActivity.this, R.string.error_api, Toast.LENGTH_SHORT).show();
                }
            });
        }*/


    }
}
