package com.example.newSB.service;

import com.example.newSB.DTO.PokemonDTO;
import com.example.newSB.DTO.PokemonGetAllResponse;
import com.example.newSB.entity.Pokemon;
import com.example.newSB.exception.PokemonNotFound;
import com.example.newSB.repository.PokemnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService{
    @Autowired
    private PokemnRepo pokemnRepo;

    @Autowired
    public PokemonServiceImpl(PokemnRepo pokemnRepo)
    {
        this.pokemnRepo=pokemnRepo;
    }
    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {

        Pokemon pokemon=new Pokemon();
        pokemon.setName(pokemonDTO.getName());

        pokemon.setType(pokemonDTO.getType());


        Pokemon newPokemon=pokemnRepo.save(pokemon);

        PokemonDTO pokemonResponse=new PokemonDTO();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
        return pokemonResponse;
    }

    @Override
    public PokemonGetAllResponse getAll(int pageNo,int pageSize) {
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Pokemon> pokemons=pokemnRepo.findAll(pageable);
        List<Pokemon> pokemons1=pokemons.getContent();
        List<PokemonDTO> data=pokemons1.stream().map(p->mapToDto(p)).collect(Collectors.toList());

        PokemonGetAllResponse pokemonGetAllResponse=new PokemonGetAllResponse();
        pokemonGetAllResponse.setData(data);
        pokemonGetAllResponse.setPageNo(pokemons.getNumber());
        pokemonGetAllResponse.setPageSize(pokemons.getSize());
        pokemonGetAllResponse.setTotalElements(pokemons.getTotalElements());
        pokemonGetAllResponse.setTotalPages(pokemons.getTotalPages());
        pokemonGetAllResponse.setLast(pokemons.isLast());

        return pokemonGetAllResponse;
    }

    @Override
    public PokemonDTO getPokemonById(int id) {
        Pokemon pokemon=pokemnRepo.findById(id).orElseThrow(()->new PokemonNotFound("Pkemon could not be found by ID"));

        return mapToDto(pokemon);
    }

    @Override
    public PokemonDTO updateById(PokemonDTO pokemonDTO, int id) {
        Pokemon pokemon=pokemnRepo.findById(id).orElseThrow(()-> new PokemonNotFound("could not able to update"));
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        Pokemon newPokemon=pokemnRepo.save(pokemon);

        return mapToDto(newPokemon);

    }

    @Override
    public String deletePokemon(int id) {
        pokemnRepo.deleteById(id);
        return "deleted Successfully ";
    }

    private PokemonDTO mapToDto(Pokemon pokemon)
    {
        PokemonDTO pokemonDTO=new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        return pokemonDTO;
    }
    private Pokemon mapToEntity(PokemonDTO pokemonDTO)
    {
        Pokemon pokemon=new Pokemon();
      //  pokemon.setId(pokemonDTO.getId());
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());
        return pokemon;


    }
}
