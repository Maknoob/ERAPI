package com.codingmak.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SPIRITSASHES")
public class Ashes extends BaseItem {

    private int fpCost;
    private int hpCost;
    private String effect;

    public Ashes() { }

    public int getFpCost() {
        return fpCost;
    }

    public int getHpCost() {
        return hpCost;
    }

    public String getEffect() {
        return effect;
    }

    public void setFpCost(int fpCost) {
        this.fpCost = fpCost;
    }

    public void setHpCost(int hpCost) {
        this.hpCost = hpCost;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

}
