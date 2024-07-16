package com.codingmak.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Shield extends BaseItem {

    private String passive;
    private int fpCost;
    private double weight;
    private String parrySkill;

    @Embedded
    private Require require;

    @Embedded
    private Scaling scaling;

    @Embedded
    private Attack attack;

    @Embedded
    private Guard guard;

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public int getFpCost() {
        return fpCost;
    }

    public void setFpCost(int fpCost) {
        this.fpCost = fpCost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getParrySkill() {
        return parrySkill;
    }

    public void setParrySkill(String parrySkill) {
        this.parrySkill = parrySkill;
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
