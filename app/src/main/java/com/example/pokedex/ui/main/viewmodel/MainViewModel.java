package com.example.pokedex.ui.main.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokedex.network.PokeLoader;
import com.example.pokedex.network.models.Pokemon;
import com.example.pokedex.network.models.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    PokeLoader repository;

    public MainViewModel(PokeLoader repository) {
        this.repository = repository;
    }

    private MutableLiveData<List<Pokemon>> pokemonsList;
    public LiveData<List<Pokemon>> getPokemonsList() {
        if (pokemonsList == null) {
            pokemonsList = new MutableLiveData<>();
            loadPokemonsList();
        }
        return pokemonsList;
    }

    private void loadPokemonsList() {
        Call<PokemonResponse> response = repository.getPokemonList();
        response.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    pokemonsList.setValue(response.body().getPokemonList());
                } else {
                    Log.e("Request Error :: ", String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("Network Error :: ", t.getMessage());
            }
        });
    }
}
