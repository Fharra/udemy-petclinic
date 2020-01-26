package org.springframework.samples.petclinic.bootstrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Speciality;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.services.OwnerService;
import org.springframework.samples.petclinic.services.PetTypeService;
import org.springframework.samples.petclinic.services.SpecialtyService;
import org.springframework.samples.petclinic.services.VetService;
import org.springframework.samples.petclinic.services.VisitService;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public DataLoader(OwnerService ownerService, VetService vetService,
        PetTypeService petTypeService, SpecialtyService specialtyService,
        VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Perrete1");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Perrete1");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Owner 1");
        owner1.setLastName("LastName ");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("London");
        owner1.setTelephone("913456694");
        ownerService.save(owner1);


        Pet dogWithOwner = new Pet();
        dogWithOwner.setPetType(saveDogPetType);
        dogWithOwner.setOwner(owner1);
        dogWithOwner.setBirthDate(LocalDate.now());
        dogWithOwner.setName("Rosco");
        owner1.getPets().add(dogWithOwner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Pitufico");
        owner2.setLastName("Ignacion Elpijo");
        owner2.setAddress("15 Sesame Street");
        owner2.setCity("Paris");
        owner2.setTelephone("91345669");
        ownerService.save(owner2);

        Pet catWithOwner = new Pet();
        catWithOwner.setPetType(saveCatPetType);
        catWithOwner.setOwner(owner2);
        catWithOwner.setBirthDate(LocalDate.now());
        catWithOwner.setName("Rosco");
        owner1.getPets().add(catWithOwner);


        Visit visit = new Visit();
        visit.setPet(catWithOwner);
        visit.setDate(LocalDate.now());
        visit.setDescription("first visit");
        visitService.save(visit);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadio = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loading owners");
        Vet vet1 = new Vet();
        vet1.setFirstName("El veterinario guaperas");
        vet1.setLastName("Rubio");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadio);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rupert");
        vet2.setLastName("Jaimito");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        System.out.println("Loading vets");
    }
}
