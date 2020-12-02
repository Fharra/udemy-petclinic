package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
