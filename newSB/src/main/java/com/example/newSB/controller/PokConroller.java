package com.example.newSB.controller;

import com.example.newSB.DTO.PokemonDTO;
import com.example.newSB.DTO.PokemonGetAllResponse;
import com.example.newSB.entity.Pokemon;
import com.example.newSB.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokConroller {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    public PokConroller(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemonList")
    public ResponseEntity<PokemonGetAllResponse> getPokemon(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "6",required = false) int pageSize
    )
    {

       return  new ResponseEntity<>(pokemonService.getAll(pageNo,pageSize),HttpStatus.OK);
    }
    @GetMapping("pokemonList/{id}")
    public PokemonDTO pokemonDetails(@PathVariable int id)
    {
        return pokemonService.getPokemonById(id);
    }
    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDTO> createPokemom(@RequestBody PokemonDTO pokemonDTO)
    {

        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDTO),HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDTO> updatepok(@RequestBody PokemonDTO pokemonDTO,@PathVariable("id") int id )
    {
        PokemonDTO response=pokemonService.updateById(pokemonDTO,id);
        System.out.println(response.getName());
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") int id)
    {
        //System.out.println("deleted successfully");
        String result=pokemonService.deletePokemon(id);
        return ResponseEntity.ok(result);
    }

}
