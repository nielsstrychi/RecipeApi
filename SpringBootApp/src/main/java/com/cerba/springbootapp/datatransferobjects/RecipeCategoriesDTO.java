package com.cerba.springbootapp.datatransferobjects;

public class RecipeCategoriesDTO extends DataTransferObject {

    private String name;

    public RecipeCategoriesDTO() {
    }

    public RecipeCategoriesDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
