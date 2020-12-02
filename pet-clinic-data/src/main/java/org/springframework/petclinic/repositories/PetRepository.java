package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
