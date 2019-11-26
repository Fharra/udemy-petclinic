package org.springframework.samples.petclinic.services;

import java.util.Set;
import org.springframework.samples.petclinic.model.Pet;

public interface PetService {
    Set<Pet> findAll();
    Pet findById(Long id);
    Pet save(Pet owner);
}
