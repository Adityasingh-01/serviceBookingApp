package com.service.demo.vo;

public class Vehicle {

    private String Model;
    private String ModelID;
    private String Type;
    private String Variant;
    private String Owner;
    private String Power;
    private String Weight;
    private int Services;
    private int ServiceCost;
    private int RegistrationNo;
    private boolean Insurance;

    public Vehicle(String model, String modelID, String type, String variant, String owner, String power, String weight, int services, int serviceCost, int registrationNo, boolean insurance) {
        Model = model;
        ModelID = modelID;
        Type = type;
        Variant = variant;
        Owner = owner;
        Power = power;
        Weight = weight;
        Services = services;
        ServiceCost = serviceCost;
        RegistrationNo = registrationNo;
        Insurance = insurance;
    }



}
