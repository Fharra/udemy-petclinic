package org.springframework.samples.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
