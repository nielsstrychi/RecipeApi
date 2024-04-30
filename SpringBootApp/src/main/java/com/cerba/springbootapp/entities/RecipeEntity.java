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

    private String cookingInstructions;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstuctions) {
        this.cookingInstructions = cookingInstuctions;
    }

    public LocalTime getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(LocalTime preparationTime) {
        this.preparationTime = preparationTime;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Set<RecipeIngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeCategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(RecipeCategoriesEntity category) {
        this.category = category;
    }

    public Set<DietaryRestrictionEntity> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(Set<DietaryRestrictionEntity> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
