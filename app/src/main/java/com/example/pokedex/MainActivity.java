package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pokedex.databinding.ActivityMainBinding;
import com.example.pokedex.ui.main.adapter.PokemonAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //PokemonAdapter adapter = new PokemonAdapter();
        //binding.rvMain.setAdapter(adapter);

    }
}