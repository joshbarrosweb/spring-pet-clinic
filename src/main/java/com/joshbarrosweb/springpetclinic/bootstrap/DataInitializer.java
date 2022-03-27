package com.joshbarrosweb.springpetclinic.bootstrap;

import com.joshbarrosweb.springpetclinic.entities.Owner;
import com.joshbarrosweb.springpetclinic.entities.Vet;
import com.joshbarrosweb.springpetclinic.services.OwnerService;
import com.joshbarrosweb.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    
    public DataInitializer(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Josh");
        owner1.setLastName("Barros");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Naty");
        owner1.setLastName("Barros");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Chuck");
        vet1.setLastName("Norris");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Nuck");
        vet2.setLastName("Chorris");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
