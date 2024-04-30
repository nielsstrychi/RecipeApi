package com.cerba.springbootapp.entities;

import jakarta.persistence.Entity;

@Entity
public class RecipeCategoriesEntity extends BasicEntity {
    private String name;

    public RecipeCategoriesEntity() {
    }

    public RecipeCategoriesEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
