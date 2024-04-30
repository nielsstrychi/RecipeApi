package com.cerba.springbootapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RecipeEntity extends BasicEntity {

    private String name;

    private String description;

    private String cookingInstuctions;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime preparationTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime cookingTime;

    @OneToMany
    private Set<RecipeIngredientEntity> ingredients = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID")
    private RecipeCategoriesEntity category;

    @ManyToMany
    private Set<DietaryRestrictionEntity> dietaryRestrictions = new HashSet<>();


}
