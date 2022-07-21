package com.example.pokedex.ui.main.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.pokedex.network.PokeLoader;

public class MainViewModel extends ViewModel {
    PokeLoader repository;

    public MainViewModel(PokeLoader repository) {
        this.repository = repository;
    }


}
