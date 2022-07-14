package com.example.pokedex.network;

import com.example.pokedex.network.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeAPI {

    @GET("pokemon")
    Call<PokemonResponse> getPokemonList();
}
