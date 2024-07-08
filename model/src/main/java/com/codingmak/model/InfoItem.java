package com.codingmak.model;

import jakarta.persistence.Entity;

@Entity
public class InfoItem extends BaseItem {
    private String information;
    private String location;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}