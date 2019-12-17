package com.example.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 *
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // hide the default action bar
        getSupportActionBar().hide();

        // get data to display in detail
        String name = getIntent().getExtras().getString("hero_name");

        // initialize views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView textView_name = findViewById(R.id.detail_hero_name);
        TextView textView_appearance = findViewById(R.id.detail_appearance);
        TextView textView_biography = findViewById(R.id.detail_biography);
        TextView textView_occupation = findViewById(R.id.detail_hero_occupation);
        TextView textView_powerstats = findViewById(R.id.detail_powerstats);
        ImageView imgView_thumbnail = findViewById(R.id.detail_thumbnail);

        // set value of views
        textView_name.setText(name);

        collapsingToolbarLayout.setTitle(name);
    }
}
