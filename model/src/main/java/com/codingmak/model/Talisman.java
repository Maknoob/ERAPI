package com.codingmak.model;

import jakarta.persistence.Entity;

@Entity
public class Talisman extends BaseItem {
    private double weight;
    private String effect;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
