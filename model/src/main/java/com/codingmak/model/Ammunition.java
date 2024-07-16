package com.codingmak.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Ammunition extends BaseItem {
    private String passive;

    @Embedded
    private Attack attack;

    public Ammunition() {

    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }
}
