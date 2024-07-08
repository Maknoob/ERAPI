package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CrystalTear extends BaseItem {
    private String whenUsed;
    private int durationInSec;
    private String location;

    public String getWhenUsed() {
        return whenUsed;
    }

    public void setWhenUsed(String whenUsed) {
        this.whenUsed = whenUsed;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
