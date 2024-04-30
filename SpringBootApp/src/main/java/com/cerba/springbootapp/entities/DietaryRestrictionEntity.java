package com.cerba.springbootapp.entities;

import jakarta.persistence.Entity;

@Entity
public class DietaryRestrictionEntity extends BasicEntity{

    private String name;

    public DietaryRestrictionEntity() {
    }

    public DietaryRestrictionEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
