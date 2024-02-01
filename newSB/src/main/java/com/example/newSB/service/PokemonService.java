package com.example.newSB.service;

import com.example.newSB.DTO.PokemonDTO;
import com.example.newSB.DTO.PokemonGetAllResponse;

import java.util.*;
public interface PokemonService {

    PokemonDTO createPokemon(PokemonDTO pokemonDTO);
    PokemonGetAllResponse getAll(int pageNo, int pageSize);

    PokemonDTO getPokemonById(int id);

    PokemonDTO updateById(PokemonDTO pokemonDTO,int id);

    String deletePokemon(int id);
}
