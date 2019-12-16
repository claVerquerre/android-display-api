package com.example.myapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.model.Hero;
import com.example.myapplication.network.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Hero> heroList = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataRequest();
    }

    /**
     *
     */
    private void dataRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://akabab.github.io/superhero-api/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<Hero>> call = requestInterface.getHeroesJson();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList = new ArrayList<>(response.body());
                adapter = new RecyclerViewAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_api, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
