package com.example.myapplication.adapter;

import android.content.Context;
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
 *
 */
public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private ArrayList<HeroesModel> heroesModels;
    private Context context;


    public HeroesAdapter(Context context, ArrayList<HeroesModel> heroesModels) {
        this.heroesModels = heroesModels;
        this.context = context;
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

        Picasso.get().load(heroesModels.get(i).getImage().getSm()).into(viewHolder.hero_image);
    }

    @Override
    public int getItemCount() {
        return heroesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView hero_image;
        private TextView hero_name, hero_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hero_image = itemView.findViewById(R.id.hero_image);
            hero_name = itemView.findViewById(R.id.hero_name);
            hero_desc = itemView.findViewById(R.id.hero_desc);
        }
    }
}
