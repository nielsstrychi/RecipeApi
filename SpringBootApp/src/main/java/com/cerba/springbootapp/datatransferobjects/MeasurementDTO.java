package com.cerba.springbootapp.datatransferobjects;

public class MeasurementDTO extends DataTransferObject {

    private String measurement;

    public MeasurementDTO() {
    }

    public MeasurementDTO(String measurement) {
        this.measurement = measurement;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
