package com.example.newSB.repository;

import com.example.newSB.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemnRepo extends JpaRepository<Pokemon,Integer> {

}
