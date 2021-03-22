package com.service.demo.vo;

public class Booking {

    private String customer;
    private String vehicle;
    private int timeSlot;
    private String bookingStatus;
    private int cost;
    private boolean paymentDone;


    public Booking(String customer, String vehicle, int timeSlot, String bookingStatus, int cost, boolean paymentDone) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.timeSlot = timeSlot;
        this.bookingStatus = bookingStatus;
        this.cost = cost;
        this.paymentDone = paymentDone;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }
}
