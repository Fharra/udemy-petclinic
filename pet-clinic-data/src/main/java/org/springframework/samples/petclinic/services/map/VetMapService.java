package org.springframework.samples.petclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.model.Speciality;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.services.SpecialtyService;
import org.springframework.samples.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
