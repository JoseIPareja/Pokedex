package com.example.pokedex.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.pokedex.R;
import com.example.pokedex.network.models.Pokemon;
import java.util.Objects;

public class PokemonAdapter extends ListAdapter<Pokemon, PokemonViewHolder> {

    public PokemonAdapter(@NonNull DiffUtil.ItemCallback<Pokemon> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon item = getItem(position);
        holder.drawPokemon(item);
    }

    public static class DepDiff extends DiffUtil.ItemCallback<Pokemon> {

        @Override
        public boolean areItemsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
            return Objects.equals(oldItem.getName(), newItem.getName());
        }
    }

}
