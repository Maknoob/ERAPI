package com.codingmak.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Weapon {
    @Id
    private Long id;
    private String name;
    private String type;
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
    private String dlc;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getDlc() {
        return dlc;
    }

    public void setDlc(String dlc) {
        this.dlc = dlc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
