package org.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
