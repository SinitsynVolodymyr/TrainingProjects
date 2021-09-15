package com;

import java.util.Objects;

public class Driver {
    private Human human;
    private DriverLicense driverLicense;
    private CarDriver carDriver;

    public Driver() {
    }

    public Driver(Human human, DriverLicense driverLicense) {
        this.human = human;
        this.driverLicense = driverLicense;
    }

    public CarDriver getCarDriver() {
        return carDriver;
    }

    public void move(){
        Objects.requireNonNull(carDriver);
        carDriver.move();

    }

    public void stop(){
        Objects.requireNonNull(carDriver);
        carDriver.stop();
    }

    public void setCarDriver(CarDriver carDriver) {
        this.carDriver = carDriver;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "human=" + human +
                ", driverLicense=" + driverLicense +
                '}';
    }
}
