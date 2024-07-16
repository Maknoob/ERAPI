package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Attack {

    @Column(name = "attack_physical")
    private int physical;

    @Column(name = "attack_magical")
    private int magical;

    @Column(name = "attack_fire")
    private int fire;

    @Column(name = "attack_lightning")
    private int lightning;

    @Column(name = "attack_holy")
    private int holy;

    @Column(name = "attack_critical")
    private int critical;

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

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }
}