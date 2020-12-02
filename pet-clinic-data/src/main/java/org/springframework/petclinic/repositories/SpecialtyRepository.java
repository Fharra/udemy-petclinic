package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {

}
