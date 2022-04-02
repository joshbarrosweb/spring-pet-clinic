package com.joshbarrosweb.springpetclinic.bootstrap;

import com.joshbarrosweb.springpetclinic.entities.Owner;
import com.joshbarrosweb.springpetclinic.entities.Pet;
import com.joshbarrosweb.springpetclinic.entities.PetType;
import com.joshbarrosweb.springpetclinic.entities.Vet;
import com.joshbarrosweb.springpetclinic.services.OwnerService;
import com.joshbarrosweb.springpetclinic.services.PetTypeService;
import com.joshbarrosweb.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Josh");
        owner1.setLastName("Barros");
        owner1.setAddress("Ricardo de Albuquerque");
        owner1.setCity("Rio de Janeiro");
        owner1.setTelephone("21 920201550");

        Pet joshPet = new Pet();
        joshPet.setPetType(savedCatPetType);
        joshPet.setOwner(owner1);
        joshPet.setBirthDate(LocalDate.now());
        joshPet.setName("Larxene");
        owner1.getPets().add(joshPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Naty");
        owner2.setLastName("Barros");
        owner2.setAddress("Ricardo de Albuquerque");
        owner2.setCity("Rio de Janeiro");
        owner2.setTelephone("21 920201550");

        Pet natyPet = new Pet();
        natyPet.setPetType(savedDogPetType);
        natyPet.setOwner(owner2);
        natyPet.setBirthDate(LocalDate.now());
        natyPet.setName("Vanellope");
        owner2.getPets().add(natyPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Chuck");
        vet1.setLastName("Norris");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nuck");
        vet2.setLastName("Chorris");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
