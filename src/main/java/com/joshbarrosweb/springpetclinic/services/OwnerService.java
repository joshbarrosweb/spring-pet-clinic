package com.joshbarrosweb.springpetclinic.services;

import com.joshbarrosweb.springpetclinic.entity.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findbyLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
