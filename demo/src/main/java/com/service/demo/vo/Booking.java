package com.service.demo.vo;

public class Booking {

    private String Customer;
    private String Vehicle;
    private int TimeSlot;
    private String BookingStatus;
    private int Cost;
    private boolean PaymentDone;


    public Booking(String customer, String vehicle, int timeSlot, String bookingStatus, int cost, boolean paymentDone) {
        Customer = customer;
        Vehicle = vehicle;
        TimeSlot = timeSlot;
        BookingStatus = bookingStatus;
        Cost = cost;
        PaymentDone = paymentDone;
    }



}
