package com;

public class Refueler {

    private String name;
    private String nameCompany;

    public Refueler() {
    }

    public Refueler(String name, String nameCompany) {
        this.name = name;
        this.nameCompany = nameCompany;
    }

    public void refuelCar(CarRefueler carRefueler){
        carRefueler.openFuelTankCover();
        carRefueler.refuel();
        carRefueler.closeFuelTankCover();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }
}
