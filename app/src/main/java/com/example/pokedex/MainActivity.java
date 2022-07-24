package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.pokedex.databinding.ActivityMainBinding;
import com.example.pokedex.ui.main.adapter.PokemonAdapter;
import com.example.pokedex.ui.main.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainViewModel viewModel = new ViewModelProvider.NewInstanceFactory()
        viewModel.getPokemonsList().observe(this, pokemons -> {
            PokemonAdapter adapter = new PokemonAdapter(pokemons, this);
            binding.rvMain.setAdapter(adapter);
        });

    }
}