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
import android.widget.Toast;

import com.example.myapplication.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.adapters.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;
import com.example.myapplication.utils.OnHeroClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_heroes);

        // get info from the database
        // don't use because not such info in the database to display detail
        // List<HeroesModel> heroesModelList
        //        = new ArrayList<>(DBHelper.getInstance(requireContext()).getAllHeroes());

        initializeApi();
        return view;
    }

    /**
     * Initialize API to get a response or a failure.
     */
    private void initializeApi() {

        MyApplication.getApi().getHeroes().enqueue(new Callback<List<HeroesModel>>() {
            @Override
            public void onResponse(Call<List<HeroesModel>> call, Response<List<HeroesModel>> response) {
                List<HeroesModel> heroesModelList = new ArrayList<>(response.body());
                initializeAdapter(heroesModelList);
            }

            @Override
            public void onFailure(Call<List<HeroesModel>> call, Throwable t) {
                Toast.makeText(requireActivity(), "failure", Toast.LENGTH_SHORT).show();
            }
        });
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
        setItemOnClickListener(heroesAdapter);
        recyclerView.setAdapter(heroesAdapter);
    }

    /**
     * set detail fragment with the clicked hero.
     * @param heroesAdapter heroes adapter
     */
    private void setItemOnClickListener(HeroesAdapter heroesAdapter) {
        HeroesAdapter.setOnItemClickedListener(new OnHeroClickListener() {
            @Override
            public void onItemClick(HeroesModel hero) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("hero", hero);

                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(bundle);
                android.app.FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
