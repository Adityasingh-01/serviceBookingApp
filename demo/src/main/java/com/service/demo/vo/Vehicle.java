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
    private String manufacturer;
    private String modelName;
    private String nickName;
    private String type;
    private String power;
    private String weight;
    private int services;
    private String registrationNo;
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

    public Vehicle(String manufacturer, String modelName, String nickName, String power, String weight, int services, String registrationNo, Customer owner, boolean insurance) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.modelName = modelName;
        this.nickName = nickName;
        this.power = power;
        this.weight = weight;
        this.services = services;
        this.registrationNo = registrationNo;
        this.owner = owner;
        this.insurance = insurance;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
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
                "model='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", variant='" + modelName + '\'' +
                ", variant='" + nickName + '\'' +
                ", power='" + power + '\'' +
                ", weight='" + weight + '\'' +
                ", services=" + services +
                ", registrationNo=" + registrationNo +
                ", insurance=" + insurance +
                ", owner=" + owner +
                ", bookings=" + bookings;
    }
}
