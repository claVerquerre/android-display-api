package com.example.myapplication.di;

import com.example.myapplication.model.HeroService;
import com.example.myapplication.viewmodel.HeroesListViewModel;

import dagger.Component;

@Component(modules = {RetrofitInstance.class})
public interface ApiComponent {

    void inject(HeroService service);

    void inject(HeroesListViewModel viewModel);
}
