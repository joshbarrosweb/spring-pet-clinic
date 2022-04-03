package com.joshbarrosweb.springpetclinic.repositories;

import com.joshbarrosweb.springpetclinic.entities.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
