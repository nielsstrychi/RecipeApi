package com.cerba.springbootapp.datatransferobjects;

import com.cerba.springbootapp.entities.DietaryRestrictionEntity;
import com.cerba.springbootapp.entities.RecipeCategoriesEntity;
import com.cerba.springbootapp.entities.RecipeIngredientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class RecipeDTO extends DataTransferObject {

    private String name;

    private String description;

    private String cookingInstructions;
    private LocalTime preparationTime;

    private LocalTime cookingTime;

    private Set<RecipeIngredientDTO> ingredients;

    private RecipeCategoriesDTO category;

    private Set<DietaryRestrictionDTO> dietaryRestrictions;

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

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
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

    public Set<RecipeIngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeCategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(RecipeCategoriesDTO category) {
        this.category = category;
    }

    public Set<DietaryRestrictionDTO> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(Set<DietaryRestrictionDTO> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
