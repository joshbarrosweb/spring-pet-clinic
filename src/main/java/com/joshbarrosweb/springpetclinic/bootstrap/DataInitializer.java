package com.joshbarrosweb.springpetclinic.bootstrap;

import com.joshbarrosweb.springpetclinic.entities.Owner;
import com.joshbarrosweb.springpetclinic.entities.PetType;
import com.joshbarrosweb.springpetclinic.entities.Vet;
import com.joshbarrosweb.springpetclinic.services.OwnerService;
import com.joshbarrosweb.springpetclinic.services.PetTypeService;
import com.joshbarrosweb.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Naty");
        owner2.setLastName("Barros");

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
