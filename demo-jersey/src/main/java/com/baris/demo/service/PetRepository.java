package com.baris.demo.service;

import com.baris.demo.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository interface for <code>Pet</code> domain objects
 */
public interface PetRepository extends Repository<Pet, Integer> {

    @Query("SELECT pet FROM Pet pet WHERE pet.id =:id")
    @Transactional(readOnly = true)
    Pet findById(@Param("id") Integer id);

    @Query("SELECT pet FROM Pet pet ORDER BY pet.id")
    @Transactional(readOnly = true)
    List<Pet> findAll();

    Pet save(Pet pet);
}
