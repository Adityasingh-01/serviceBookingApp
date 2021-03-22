package com.service.demo.vo;

public class Customer {

private String firstName;
private String lastName;
private int vehicles;
private String address;
private int registrationID;
private int contactNo;
private int bookings;

    public Customer(String firstName, String lastName, int vehicles, String address, int registrationID, int contactNo, int bookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicles = vehicles;
        this.address = address;
        this.registrationID = registrationID;
        this.contactNo = contactNo;
        this.bookings = bookings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }
}
