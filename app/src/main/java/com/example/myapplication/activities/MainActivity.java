package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.model.Hero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

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


        /*JsonArrayRequest request = new JsonArrayRequest(api_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Hero hero = new Hero();

                        hero.setName(jsonObject.getString("name"));
                        hero.setPowerstats(jsonObject.getJSONObject("powerstats").getString("intelligence"));
                        hero.setAppearance(jsonObject.getJSONObject("appearance").getString("gender"));
                        hero.setBiography(jsonObject.getJSONObject("biography").getString("fullName"));
                        hero.setWork(jsonObject.getJSONObject("work").getString("occupation"));
                        hero.setImage(jsonObject.getJSONObject("images").getString("sm"));

                        heroList.add(hero);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, R.string.error_api, Toast.LENGTH_SHORT).show();
            }
        });*/

        /*RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);*/

        /* GetHeroesDataService heroDataService = RetrofitInstance.getRetrofitInstance().create(GetHeroesDataService.class);
        Call<List<Hero>> call = heroDataService.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();
                if (heroes != null) {
                    heroList.addAll(heroes);
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_api, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
