package com.example.pokedex.ui.main.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.databinding.MainRecyclerItemBinding;
import com.example.pokedex.network.models.Pokemon;
import com.squareup.picasso.Picasso;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private final MainRecyclerItemBinding binding = MainRecyclerItemBinding.bind(itemView);

    public void drawPokemon(Pokemon pokemon) {
        binding.tvPokemonTitle.setText(pokemon.getName());
        Picasso.get().load(pokemon.getUrl()).into(binding.ivPokemon);
        binding.tvPokemonDescription.setText(pokemon.getName());
    }
}
