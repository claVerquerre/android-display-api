package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class HeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        // hide the default action bar
        getSupportActionBar().hide();

        // get data to display in detail
        String name = getIntent().getExtras().getString("hero_name");
        String powerstats = getIntent().getExtras().getString("hero_powerstats");
        String biography = getIntent().getExtras().getString("hero_biography");
        String appearance = getIntent().getExtras().getString("hero_appearance");
        String work = getIntent().getExtras().getString("hero_work");
        String image = getIntent().getExtras().getString("hero_image");

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
        textView_appearance.setText(appearance);
        textView_biography.setText(biography);
        textView_occupation.setText(work);
        textView_powerstats.setText(powerstats);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

        // for set image, use glide
        Glide.with(this)
                .load(image)
                .apply(requestOptions)
                .into(imgView_thumbnail);
    }
}
