package com.codingmak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AshOfWar extends BaseItem {
    private String availability;
    private String skill;

    @Column(columnDefinition = "LONGTEXT")
    private String skillEffect;
    private String affinity;

    @Column(columnDefinition = "LONGTEXT")
    private String location;

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(String skillEffect) {
        this.skillEffect = skillEffect;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
