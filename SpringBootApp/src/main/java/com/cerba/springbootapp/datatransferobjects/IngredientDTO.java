package com.cerba.springbootapp.datatransferobjects;

public class IngredientDTO extends DataTransferObject {

    private String name;

    public IngredientDTO() {
    }

    public IngredientDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
