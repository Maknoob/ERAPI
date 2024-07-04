package com.codingmak.model;

import jakarta.persistence.Entity;

@Entity
public class Ammunition extends BaseItem {
    private int attackPhy;
    private int attackMag;
    private int attackFire;
    private int attackLigt;
    private int attackHoly;
    private int attackCrit;
    private String passive;

    public Ammunition() {

    }

    public int getAttackPhy() {
        return attackPhy;
    }

    public void setAttackPhy(int attackPhy) {
        this.attackPhy = attackPhy;
    }

    public int getAttackMag() {
        return attackMag;
    }

    public void setAttackMag(int attackMag) {
        this.attackMag = attackMag;
    }

    public int getAttackFire() {
        return attackFire;
    }

    public void setAttackFire(int attackFire) {
        this.attackFire = attackFire;
    }

    public int getAttackLigt() {
        return attackLigt;
    }

    public void setAttackLigt(int attackLigt) {
        this.attackLigt = attackLigt;
    }

    public int getAttackHoly() {
        return attackHoly;
    }

    public void setAttackHoly(int attackHoly) {
        this.attackHoly = attackHoly;
    }

    public int getAttackCrit() {
        return attackCrit;
    }

    public void setAttackCrit(int attackCrit) {
        this.attackCrit = attackCrit;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }
}
