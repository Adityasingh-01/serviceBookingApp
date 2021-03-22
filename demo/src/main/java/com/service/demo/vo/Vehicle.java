package com.service.demo.vo;

public class Vehicle {

    private String model;
    private String modelID;
    private String type;
    private String variant;
    private String owner;
    private String power;
    private String weight;
    private int services;
    private int serviceCost;
    private int registrationNo;
    private boolean insurance;

    public Vehicle(String model, String modelID, String type, String variant, String owner, String power, String weight, int services, int serviceCost, int registrationNo, boolean insurance) {
        this.model = model;
        this.modelID = modelID;
        this.type = type;
        this.variant = variant;
        this.owner = owner;
        this.power = power;
        this.weight = weight;
        this.services = services;
        this.serviceCost = serviceCost;
        this.registrationNo = registrationNo;
        this.insurance = insurance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelID() {
        return modelID;
    }

    public void setModelID(String modelID) {
        this.modelID = modelID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getServices() {
        return services;
    }

    public void setServices(int services) {
        this.services = services;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
}
