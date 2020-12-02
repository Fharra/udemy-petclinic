package org.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.petclinic.model.PetType;
import org.springframework.petclinic.repositories.PetTypeRepository;
import org.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

   private final PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
