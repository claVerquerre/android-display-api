package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.model.Hero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private final String BASE_URL = "https://superheroapi.com/api/" + MyApplication.API_KEY;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Hero> heroList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        jsonRequest();
    }

    private void jsonRequest() {
        request = new JsonArrayRequest(BASE_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i<response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        // get all information about a hero from json
                        Hero hero = new Hero();
                        hero.setName(jsonObject.getString("name"));
                        hero.setPowerstats(jsonObject.getString("powerstats"));
                        hero.setBiography(jsonObject.getString("biography"));
                        hero.setAppearance(jsonObject.getString("appearance"));
                        hero.setWork(jsonObject.getString("work"));
                        hero.setImage(jsonObject.getString("image"));
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {

        });
    }

}
