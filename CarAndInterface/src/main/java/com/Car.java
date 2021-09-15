package com;


public class Car implements CarDriver,CarBattery,CarRefueler{

    public enum Transmission { MECHANICAL , AUTOMATIC };
    private Transmission transmission;
    private String model;
    private String number;
    private String vin;
    private DriverLicense.Category category;

    boolean isMoveCar = false;
    boolean isOpenFuelTankCover = false;

    public Car() {
    }

    public Car(Transmission transmission, String model, String number, String vin, DriverLicense.Category category) {
        this.transmission = transmission;
        this.model = model;
        this.number = number;
        this.vin = vin;
        this.category = category;
    }


    @Override
    public double getHeight() {
        return 173;
    }

    @Override
    public double getWidth() {
        return 306;
    }

    @Override
    public double getDepth() {
        return 225;
    }

    @Override
    public void move() {
        if (isOpenFuelTankCover)
            System.out.println("We can't move because fuel tank cover is open");
        else {
            isMoveCar = true;
            System.out.println("The car is moving");
        }
    }

    @Override
    public void stop() {
        isMoveCar = false;
        System.out.println("The car stopped");
    }

    @Override
    public void openFuelTankCover() {
        if (isMoveCar)
            System.out.println("We can't open fuel tank cover because the car is moving");
        else {
            isOpenFuelTankCover = true;
            System.out.println("The fuel tank cover is open");
        }
    }

    @Override
    public void refuel() {
        if (!isOpenFuelTankCover)
            System.out.println("We can't refuel the car because the fuel tank cover is close");
        else {
            System.out.println("The car is refueling");
        }
    }

    @Override
    public void closeFuelTankCover() {
        if (isMoveCar)
            System.out.println("We can't close fuel tank cover because the car is moving");
        else {
            isOpenFuelTankCover = false;
            System.out.println("The fuel tank cover is close");
        }
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
