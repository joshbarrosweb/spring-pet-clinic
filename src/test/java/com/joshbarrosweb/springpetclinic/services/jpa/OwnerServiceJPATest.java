package com.joshbarrosweb.springpetclinic.services.jpa;

import com.joshbarrosweb.springpetclinic.entities.Owner;
import com.joshbarrosweb.springpetclinic.repositories.OwnerRepository;
import com.joshbarrosweb.springpetclinic.repositories.PetRepository;
import com.joshbarrosweb.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    public static final String LAST_NAME = "Barros";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJPA service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner barros = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, barros.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();

        Owner returnOwner2 = new Owner();
        returnOwner2.setId(2L);
        returnOwner2.setLastName(LAST_NAME);

        Owner returnOwner3 = new Owner();
        returnOwner3.setId(3L);
        returnOwner3.setLastName(LAST_NAME);

        returnOwnersSet.add(returnOwner2);
        returnOwnersSet.add(returnOwner3);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}