package com.joshbarrosweb.springpetclinic.repositories;

import com.joshbarrosweb.springpetclinic.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
