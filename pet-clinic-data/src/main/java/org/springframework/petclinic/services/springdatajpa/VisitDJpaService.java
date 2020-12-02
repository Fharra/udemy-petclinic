package org.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.petclinic.model.Visit;
import org.springframework.petclinic.repositories.VisitRepository;
import org.springframework.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class VisitDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
