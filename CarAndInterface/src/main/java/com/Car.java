package com;


public class Car {
    public enum Transmission { MECHANICAL , AUTOMATIC };
    private Transmission transmission;
    private String model;
    private String number;
    private String vin;
    private DriverLicense.Category category;

    public Car() {
    }

    public Car(Transmission transmission, String model, String number, String vin, DriverLicense.Category category) {
        this.transmission = transmission;
        this.model = model;
        this.number = number;
        this.vin = vin;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public String getVin() {
        return vin;
    }

    public DriverLicense.Category getCategory() {
        return category;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
