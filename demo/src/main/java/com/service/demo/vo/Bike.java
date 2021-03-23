package com.service.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends Vehicle{

    private String type;
    private String startType;
    private String suspension;
    private String braking;

    public Bike(String type, String startType, String suspension, String braking) {
        this.type = type;
        this.startType = startType;
        this.suspension = suspension;
        this.braking = braking;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public String getBraking() {
        return braking;
    }

    public void setBraking(String braking) {
        this.braking = braking;
    }

    @Override
    public String toString() {
        return "Bike{" +super.toString()+
                "type='" + type + '\'' +
                ", startType='" + startType + '\'' +
                ", suspension='" + suspension + '\'' +
                ", braking='" + braking + '\'' +
                '}';
    }
}
