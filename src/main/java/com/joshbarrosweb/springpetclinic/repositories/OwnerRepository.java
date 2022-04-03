package com.joshbarrosweb.springpetclinic.repositories;

import com.joshbarrosweb.springpetclinic.entities.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
