package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Guard {

    @Column(name = "guard_physical")
    private int physical;

    @Column(name = "guard_magical")
    private int magical;

    @Column(name = "guard_fire")
    private int fire;

    @Column(name = "guard_lightning")
    private int lightning;

    @Column(name = "guard_holy")
    private int holy;

    @Column(name = "guard_boost")
    private int boost;

    // Getter und Setter

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getMagical() {
        return magical;
    }

    public void setMagical(int magical) {
        this.magical = magical;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getLightning() {
        return lightning;
    }

    public void setLightning(int lightning) {
        this.lightning = lightning;
    }

    public int getHoly() {
        return holy;
    }

    public void setHoly(int holy) {
        this.holy = holy;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }
}