package org.springframework.samples.petclinic.services;

import java.util.Set;
import org.springframework.samples.petclinic.model.Owner;

public interface OwnerService {
    Owner findByLastName(String lastname);
    Set<Owner> findAll();
    Owner findById(Long id);
    Owner save(Owner owner);
}
