package com.example.pokedex.network;

import com.example.pokedex.network.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeLoader implements PokeAPI {
    PokeAPI api;
    final String URL_BASE = "https://pokeapi.co/ap/v2/";

    public PokeLoader() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(PokeAPI.class);
    }

    @Override
    public Call<PokemonResponse> getPokemonList() {
        return api.getPokemonList();
    }
}
