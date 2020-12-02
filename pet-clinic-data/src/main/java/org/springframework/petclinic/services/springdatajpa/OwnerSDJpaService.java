package org.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.petclinic.model.Owner;
import org.springframework.petclinic.repositories.OwnerRepository;
import org.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner findByLastName(String lastname)
    {
        return ownerRepository.findByLastName(lastname);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
