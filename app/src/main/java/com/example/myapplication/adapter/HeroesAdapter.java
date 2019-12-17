package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.*;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Adapter for heroes.
 */
public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private ArrayList<HeroesModel> heroesModels;


    public HeroesAdapter(ArrayList<HeroesModel> heroesModels) {
        this.heroesModels = heroesModels;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.heroes_list_item, viewGroup,false);
        return new HeroesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.hero_name.setText(heroesModels.get(i).getName());
        viewHolder.hero_desc.setText(heroesModels.get(i).getBiography().getFullName());
        viewHolder.hero_publisher.setText(heroesModels.get(i).getBiography().getPublisher());

        Picasso.get().load(heroesModels.get(i).getImage().getSm()).into(viewHolder.hero_image);
    }

    @Override
    public int getItemCount() {
        return heroesModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView hero_image;
        private TextView hero_name, hero_desc, hero_publisher;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            hero_image = itemView.findViewById(R.id.hero_image);
            hero_name = itemView.findViewById(R.id.hero_name);
            hero_desc = itemView.findViewById(R.id.hero_desc);
            hero_publisher = itemView.findViewById(R.id.hero_publisher);
        }
    }
}
