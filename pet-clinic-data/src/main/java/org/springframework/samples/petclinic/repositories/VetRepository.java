package org.springframework.samples.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
