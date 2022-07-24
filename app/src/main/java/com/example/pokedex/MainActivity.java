package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pokedex.databinding.ActivityMainBinding;
import com.example.pokedex.network.PokeLoader;
import com.example.pokedex.ui.main.adapter.PokemonAdapter;
import com.example.pokedex.ui.main.viewmodel.MainViewModel;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel = new MainViewModel(new PokeLoader());

        PokemonAdapter adapter = new PokemonAdapter(new PokemonAdapter.DepDiff());
        binding.rvMain.setAdapter(adapter);

        viewModel.getPokemonsList().observe(this, pokemons -> {
            adapter.submitList(pokemons);
        });
    }
}