package com;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(
                Car.Transmission.AUTOMATIC,
                "Opel",
                "АВ2536ВП",
                "4Y1SL65848Z411439",
                DriverLicense.Category.B);

        BatteryShop batteryShop = new BatteryShop();
        Driver driver = new Driver();
        Refueler refueler = new Refueler();
        driver.setCarDriver(car);

        driver.move();
        driver.stop();
        batteryShop.insertBattery(car);
        driver.move();
        refueler.refuelCar(car);
        driver.stop();
        refueler.refuelCar(car);
        driver.move();
        driver.stop();

    }

}
