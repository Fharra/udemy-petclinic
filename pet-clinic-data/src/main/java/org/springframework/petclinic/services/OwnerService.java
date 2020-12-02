package org.springframework.petclinic.services;

import org.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService <Owner, Long> {
    Owner findByLastName(String lastname);
}
