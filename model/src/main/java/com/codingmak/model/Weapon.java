package com.codingmak.model;

import jakarta.persistence.Entity;

@Entity
public class Weapon extends BaseItem {

    private double weight;
    private String skill;
    private String requires;
    private String scaling;
    private int attackPhy;
    private int attackMag;
    private int attackFire;
    private int attackLigt;
    private int attackHoly;
    private int attackCrit;
    private int guardPhy;
    private int guardMag;
    private int guardFire;
    private int guardLigt;
    private int guardHoly;
    private int guardBoost;

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

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
    }

    public String getScaling() {
        return scaling;
    }

    public void setScaling(String scaling) {
        this.scaling = scaling;
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

    public int getGuardPhy() {
        return guardPhy;
    }

    public void setGuardPhy(int guardPhy) {
        this.guardPhy = guardPhy;
    }

    public int getGuardMag() {
        return guardMag;
    }

    public void setGuardMag(int guardMag) {
        this.guardMag = guardMag;
    }

    public int getGuardFire() {
        return guardFire;
    }

    public void setGuardFire(int guardFire) {
        this.guardFire = guardFire;
    }

    public int getGuardLigt() {
        return guardLigt;
    }

    public void setGuardLigt(int guardLigt) {
        this.guardLigt = guardLigt;
    }

    public int getGuardHoly() {
        return guardHoly;
    }

    public void setGuardHoly(int guardHoly) {
        this.guardHoly = guardHoly;
    }

    public int getGuardBoost() {
        return guardBoost;
    }

    public void setGuardBoost(int guardBoost) {
        this.guardBoost = guardBoost;
    }
}

