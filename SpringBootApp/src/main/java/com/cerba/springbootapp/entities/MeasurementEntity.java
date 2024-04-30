package com.cerba.springbootapp.entities;

import jakarta.persistence.Entity;

@Entity
public class MeasurementEntity extends BasicEntity {

        private String measurement;

        public MeasurementEntity() {
        }

        public MeasurementEntity(String measurement) {
                this.measurement = measurement;
        }

        public String getMeasurement() {
                return measurement;
        }

        public void setMeasurement(String measurement) {
                this.measurement = measurement;
        }
}
