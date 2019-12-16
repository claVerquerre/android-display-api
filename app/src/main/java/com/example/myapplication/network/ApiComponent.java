package com.example.myapplication.network;

import com.example.myapplication.viewmodel.HeroesListViewModel;

import dagger.Component;

@Component(modules = {RetrofitInstance.class})
public interface ApiComponent {

    void inject(HeroesListViewModel viewModel);
}
