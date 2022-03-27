package com.joshbarrosweb.springpetclinic.services;

import com.joshbarrosweb.springpetclinic.entities.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    
}
