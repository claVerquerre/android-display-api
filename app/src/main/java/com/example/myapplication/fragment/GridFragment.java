package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;
import com.example.myapplication.adapter.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;

import java.util.ArrayList;

/**
 * Fragment to display heroes in grid.
 */
public class GridFragment extends Fragment {

    RecyclerView heroes_recyclerView;
    ArrayList<HeroesModel> heroesModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savecInstanceState) {
        View view = inflater
                .inflate(R.layout.grid_fragment, container, false);

        heroes_recyclerView = view.findViewById(R.id.hero_image);

        // get info about the hero from the database
        heroesModels.addAll(DBHelper
                .getInstance(requireContext())
                .getAllHeroes());

        initializeAdapter(heroesModels);
        return view;
    }

    /**
     * Initialize an adapter with grid layout.
     * @param heroesModels heroes list
     */
    private void initializeAdapter(ArrayList<HeroesModel> heroesModels) {
        // grid with 3 columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),
                3,
                LinearLayoutManager.VERTICAL,
                false);
        heroes_recyclerView.setLayoutManager(gridLayoutManager);

        HeroesAdapter heroesAdapter = new HeroesAdapter(heroesModels);
        heroes_recyclerView.setAdapter(heroesAdapter);
    }
}
