package com.example.myapplication.fragments;

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
import com.example.myapplication.adapters.HeroesAdapter;
import com.example.myapplication.model.HeroesModel;
import com.example.myapplication.utils.OnItemPhotoClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        recyclerView = view.findViewById(R.id.rv_heroes);
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

                // add some information about heroes on a database
                // id, name and picture url
                DBHelper.getInstance(requireContext())
                        .addHeroes(heroesModelList);

                initializeAdapter(heroesModelList);
            }

            @Override
            public void onFailure(Call<List<HeroesModel>> call, Throwable t) {
                Toast.makeText(requireActivity(), "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Initialize the adapter with a linear layout.
     * @param heroesModelList the list of heroes
     */
    private void initializeAdapter(List<HeroesModel> heroesModelList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);

        HeroesAdapter heroesAdapter = new HeroesAdapter(requireContext(), heroesModelList, 0);
        setItemOnClickListener(heroesAdapter);
        recyclerView.setAdapter(heroesAdapter);
    }

    private void setItemOnClickListener(HeroesAdapter heroesAdapter) {
        heroesAdapter.setOnItemClickedListener(new OnItemPhotoClickListener() {
            @Override
            public void onItemClick(HeroesModel hero) {
                DetailFragment fragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("hero", hero);
                fragment.setArguments(bundle);

                android.app.FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
