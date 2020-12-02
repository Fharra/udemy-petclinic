package org.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.petclinic.model.Speciality;
import org.springframework.petclinic.repositories.SpecialtyRepository;
import org.springframework.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialtyRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialtyRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
