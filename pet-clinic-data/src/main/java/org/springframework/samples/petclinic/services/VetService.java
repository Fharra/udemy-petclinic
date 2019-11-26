package org.springframework.samples.petclinic.services;

import java.util.Set;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Vet;

public interface VetService {
    Set<Vet> findAll();
    Vet findById(Long id);
    Vet save(Vet owner);
}
