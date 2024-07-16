package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Require {

    @Column(name = "requires_strength")
    private String strength;

    @Column(name = "requires_dexterity")
    private String dexterity;

    @Column(name = "requires_intelligence")
    private String intelligence;

    @Column(name = "requires_faith")
    private String faith;

    @Column(name = "requires_arcane")
    private String arcane;

    // Getter und Setter

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public String getArcane() {
        return arcane;
    }

    public void setArcane(String arcane) {
        this.arcane = arcane;
    }
}