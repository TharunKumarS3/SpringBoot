package com.example.newSB.repository;

import com.example.newSB.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {
    List<Review> findByPokemonId(int pokemonId);
}
