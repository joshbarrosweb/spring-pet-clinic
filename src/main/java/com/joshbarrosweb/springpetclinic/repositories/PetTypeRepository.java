package com.joshbarrosweb.springpetclinic.repositories;

import com.joshbarrosweb.springpetclinic.entities.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
