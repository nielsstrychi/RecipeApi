package com.cerba.springbootapp.datatransferobjects;

import java.util.UUID;

public abstract class DataTransferObject {

    private UUID uuid;

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }
}
