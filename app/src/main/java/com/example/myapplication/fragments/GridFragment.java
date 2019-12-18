package com.example.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.myapplication.adapters.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;

import java.util.ArrayList;
import java.util.List;

public class GridFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_heroes);

        // get info from the database
        List<HeroesModel> heroesModelList
                = new ArrayList<>(DBHelper.getInstance(requireContext()).getAllHeroes());

        initializeAdapter(heroesModelList);
        return view;
    }

    /**
     * Initialize the adapter with a grid that contains the heroes.
     * @param heroesModelList list of heroes
     */
    private void initializeAdapter(List<HeroesModel> heroesModelList) {
        // set a grid with 3 columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        HeroesAdapter heroesAdapter = new HeroesAdapter(requireContext(), heroesModelList, 1);
        recyclerView.setAdapter(heroesAdapter);
    }
}
