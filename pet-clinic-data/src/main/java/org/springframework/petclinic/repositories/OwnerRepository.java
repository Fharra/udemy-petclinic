package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
