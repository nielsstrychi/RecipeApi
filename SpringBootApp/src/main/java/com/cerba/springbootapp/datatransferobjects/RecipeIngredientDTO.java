package com.cerba.springbootapp.datatransferobjects;

import com.cerba.springbootapp.entities.IngredientEntity;
import com.cerba.springbootapp.entities.MeasurementEntity;
import com.cerba.springbootapp.entities.RecipeEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RecipeIngredientDTO extends DataTransferObject {

    private String ingredient;

    private String measurement;

    private Integer quantity;

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
