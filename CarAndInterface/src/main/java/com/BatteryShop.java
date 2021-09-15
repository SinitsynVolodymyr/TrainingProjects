package com;

public class BatteryShop {

    private String name;
    private String address;

    public BatteryShop() {
    }

    public BatteryShop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void insertBattery(CarBattery carBattery){
        System.out.println("Insert the battery. Size: ["+
                carBattery.getDepth()+"x"+
                carBattery.getHeight()+"x"+
                carBattery.getWidth()+"]");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
