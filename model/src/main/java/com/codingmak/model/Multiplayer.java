package com.codingmak.model;

import jakarta.persistence.Entity;

@Entity
public class Multiplayer extends BaseItem {

    private String whenUsed;
    private String location;

    public Multiplayer() {
    }

    public String getWhenUsed() {
        return whenUsed;
    }

    public void setWhenUsed(String whenUsed) {
        this.whenUsed = whenUsed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
