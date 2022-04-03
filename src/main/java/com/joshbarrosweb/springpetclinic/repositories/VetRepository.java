package com.joshbarrosweb.springpetclinic.repositories;

import com.joshbarrosweb.springpetclinic.entities.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
