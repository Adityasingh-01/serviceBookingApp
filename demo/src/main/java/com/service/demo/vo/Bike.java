package com.service.demo.vo;

public class Bike {

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
}
