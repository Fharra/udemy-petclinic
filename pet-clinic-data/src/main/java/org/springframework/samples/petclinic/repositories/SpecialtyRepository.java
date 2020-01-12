package org.springframework.samples.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {

}
