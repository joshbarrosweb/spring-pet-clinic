package com.joshbarrosweb.springpetclinic.entities;

import java.io.Serializable;

public class Base implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
