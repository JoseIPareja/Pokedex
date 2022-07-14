package com.example.pokedex.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    private int count;
    private String next;
    private String previous;
    @SerializedName("results")
    private List<Pokemon> pokemonList;
}
