package com.codingmak.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Weapon extends BaseItem {

    private double weight;
    private String skill;

    @Embedded
    private Require require;

    @Embedded
    private Scaling scaling;

    @Embedded
    private Attack attack;

    @Embedded
    private Guard guard;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Require getRequire() {
        return require;
    }

    public void setRequire(Require require) {
        this.require = require;
    }

    public Scaling getScaling() {
        return scaling;
    }

    public void setScaling(Scaling scaling) {
        this.scaling = scaling;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Guard getGuard() {
        return guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }
}

