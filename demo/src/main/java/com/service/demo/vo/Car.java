package com.service.demo.vo;

public class Car  {

    private String transmission;
    private int seats;
    private int doors;

    public Car(String transmission, int seats, int doors) {
        this.transmission = transmission;
        this.seats = seats;
        this.doors = doors;
    }


    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
