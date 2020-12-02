package org.springframework.petclinic.bootstrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.petclinic.model.Owner;
import org.springframework.petclinic.model.Pet;
import org.springframework.petclinic.model.PetType;
import org.springframework.petclinic.model.Speciality;
import org.springframework.petclinic.model.Vet;
import org.springframework.petclinic.model.Visit;
import org.springframework.petclinic.services.OwnerService;
import org.springframework.petclinic.services.PetService;
import org.springframework.petclinic.services.PetTypeService;
import org.springframework.petclinic.services.SpecialtyService;
import org.springframework.petclinic.services.VetService;
import org.springframework.petclinic.services.VisitService;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
    private final PetService petService;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public DataLoader(OwnerService ownerService, VetService vetService,
        PetTypeService petTypeService, SpecialtyService specialtyService,
        VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
        this.petService = petService;
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

        Owner owner1 = Owner.builder().address("123 Brickerel").city("London").telephone("913456694").id(1l)
            .firstName("Owner 1").lastName("LastName").build();
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
        petService.save(catWithOwner);
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
