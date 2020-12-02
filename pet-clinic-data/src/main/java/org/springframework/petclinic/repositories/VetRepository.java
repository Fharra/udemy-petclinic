package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
