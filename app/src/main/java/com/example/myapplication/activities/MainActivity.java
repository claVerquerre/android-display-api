package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.model.Hero;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private final String BASE_URL = "https://superheroapi.com/api/" + MyApplication.API_KEY + "/";
    private JsonObjectRequest request;
    private List<Hero> heroList;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        heroList = new ArrayList<>();

        jsonRequest();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, heroList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     *
     */
    private void jsonRequest() {

        for (int i=1; i<=10; i++){

            String url = BASE_URL + i;
            request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    // try {
                        // get all information about a hero from json
                        Hero hero = new Hero();
                        hero.setName("test"); // response.getString("name")
                        hero.setPowerstats("test"); // response.getString("powerstats")
                        hero.setBiography("test"); // response.getString("biography")
                        hero.setAppearance("test"); // response.getString("appearance")
                        hero.setWork("test"); // response.getString("work")
                        hero.setImage("test"); // response.getString("image")

                        heroList.add(hero);
                    // }
                    // catch (JSONException e) {
                        // e.printStackTrace();
                    // }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }
    }
}
