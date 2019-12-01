package org.springframework.samples.petclinic.services.map;

import java.util.Set;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return null;
    }


    @Override
    public Owner save(Owner Object) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

}
