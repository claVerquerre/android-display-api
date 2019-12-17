package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.adapter.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The main fragment of the application.
 */
public class MainFragment extends Fragment {

    ArrayList<HeroesModel> heroesModels = new ArrayList<>();
    private HeroesAdapter heroesAdapter;
    private RecyclerView heroes_recyclerview;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.main_fragment, container, false);

        heroes_recyclerview = view.findViewById(R.id.heroes_recyclerview);
        getHeroesResponse();

        return view;
    }

    /**
     * Get response of the superhero api.
     */
    private void getHeroesResponse() {
        MyApplication.getmApi().getHeroesJson().enqueue(new Callback<List<HeroesModel>>() {
            @Override
            public void onResponse(Call<List<HeroesModel>> call, Response<List<HeroesModel>> response) {
                heroesModels = new ArrayList<>(response.body());
                heroesAdapter = new HeroesAdapter(heroesModels);

                // save in a local database (used for displaying in grid)
                DBHelper.getInstance(requireContext()).addHeroes(heroesModels);

                initializeAdapter(heroesModels);
            }

            @Override
            public void onFailure(Call<List<HeroesModel>> call, Throwable t) {
                Toast.makeText(requireActivity(),"Failed",Toast.LENGTH_SHORT).show();

            }
        });
    }

    /**
     * initialize the adapter in lines.
     * @param heroesModels list of heroes
     */
    private void initializeAdapter(ArrayList<HeroesModel> heroesModels) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        heroes_recyclerview.setLayoutManager(layoutManager);

        HeroesAdapter heroesAdapter = new HeroesAdapter(heroesModels);
        heroes_recyclerview.setAdapter(heroesAdapter);
    }

}
