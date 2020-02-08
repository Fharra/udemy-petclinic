package org.springframework.samples.petclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.services.OwnerService;
import org.springframework.samples.petclinic.services.PetService;
import org.springframework.samples.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService,
        PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


    @Override
    public Owner save(Owner object) {
        if(object != null){
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastname) {
        return null;
    }
}
