package com.cerba.springbootapp.datatransferobjects;

public class DietaryRestrictionDTO extends DataTransferObject {

    private String name;

    public DietaryRestrictionDTO() {
    }

    public DietaryRestrictionDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
