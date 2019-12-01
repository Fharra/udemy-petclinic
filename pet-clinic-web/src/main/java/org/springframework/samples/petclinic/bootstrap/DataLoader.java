package org.springframework.samples.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.services.OwnerService;
import org.springframework.samples.petclinic.services.VetService;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Owner 1");
        owner1.setLastName("LastName ");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Pitufico");
        owner2.setLastName("Ignacion Elpijo");
        ownerService.save(owner2);
        System.out.println("Loading owners");
        Vet vet1 = new Vet();
        vet1.setFirstName("El veterinario guaperas");
        vet1.setLastName("Rubio");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Rupert");
        vet2.setLastName("Jaimito");
        vetService.save(vet2);
        System.out.println("Loading vets");
    }
}
