package com.joshbarrosweb.springpetclinic.services;

import com.joshbarrosweb.springpetclinic.entity.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
