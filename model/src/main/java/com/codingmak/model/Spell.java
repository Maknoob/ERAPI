package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Spell extends BaseItem {
    private int slot;
    private int fpCost;
    private int staminaCost;
    private String requiredStats;
    private String effect;
    private String bonus;
    @Column(columnDefinition = "LONGTEXT")
    private String location;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getFpCost() {
        return fpCost;
    }

    public void setFpCost(int fpCost) {
        this.fpCost = fpCost;
    }

    public int getStaminaCost() {
        return staminaCost;
    }

    public void setStaminaCost(int staminaCost) {
        this.staminaCost = staminaCost;
    }

    public String getRequiredStats() {
        return requiredStats;
    }

    public void setRequiredStats(String requiredStats) {
        this.requiredStats = requiredStats;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
