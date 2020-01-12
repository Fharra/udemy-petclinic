package org.springframework.samples.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
