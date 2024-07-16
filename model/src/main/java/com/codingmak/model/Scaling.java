package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Scaling {

    @Column(name = "scaling_strength")
    private String strength;

    @Column(name = "scaling_dexterity")
    private String dexterity;

    @Column(name = "scaling_intelligence")
    private String intelligence;

    @Column(name = "scaling_faith")
    private String faith;

    @Column(name = "scaling_arcane")
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