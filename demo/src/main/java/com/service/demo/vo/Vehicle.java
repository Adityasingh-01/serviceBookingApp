package com.service.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String modelID;
    private String type;
    private String variant;
    private String power;
    private String weight;
    private int services;
    private int serviceCost;
    private int registrationNo;
    private boolean insurance;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer owner;
    @OneToMany
    private List<Booking> bookings;

    public Vehicle() {
    }

    public Vehicle(String model, String modelID, String type, String variant, String power, String weight, int services, int serviceCost, int registrationNo, Customer owner, boolean insurance) {
        this.model = model;
        this.modelID = modelID;
        this.type = type;
        this.variant = variant;
        this.power = power;
        this.weight = weight;
        this.services = services;
        this.serviceCost = serviceCost;
        this.registrationNo = registrationNo;
        this.owner = owner;
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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                "model='" + model + '\'' +
                ", modelID='" + modelID + '\'' +
                ", type='" + type + '\'' +
                ", variant='" + variant + '\'' +
                ", power='" + power + '\'' +
                ", weight='" + weight + '\'' +
                ", services=" + services +
                ", serviceCost=" + serviceCost +
                ", registrationNo=" + registrationNo +
                ", insurance=" + insurance +
                ", owner=" + owner +
                ", bookings=" + bookings;
    }
}
