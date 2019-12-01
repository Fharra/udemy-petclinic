package org.springframework.samples.petclinic.services;

import org.springframework.samples.petclinic.model.Owner;

public interface OwnerService extends CrudService <Owner, Long> {
    Owner findByLastName(String lastname);
}
