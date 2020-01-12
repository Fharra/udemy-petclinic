package org.springframework.samples.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
