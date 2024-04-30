package com.cerba.springbootapp.entities;

import jakarta.persistence.Entity;

@Entity
public class IngredientEntity extends BasicEntity {

    private String name;

    public IngredientEntity() {

    }

    public IngredientEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
