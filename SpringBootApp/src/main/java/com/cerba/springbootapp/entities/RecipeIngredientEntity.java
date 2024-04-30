package com.cerba.springbootapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RecipeIngredientEntity extends BasicEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="RECIPE_ID")
    private RecipeEntity recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="INGREDIENT_ID")
    private IngredientEntity ingredient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEASUREMENT_ID")
    private MeasurementEntity measurement;

    private Integer quantity;


}
