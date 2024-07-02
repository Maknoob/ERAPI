package com.codingmak.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SPIRITSASHES")
public class Ashes {
    @Id

    private Long id;
    private String name;
    private String type;
    private int fpCost;
    private int hpCost;
    private String effect;
    private String dlc;
    private String image;

    public Ashes() { }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getFpCost() {
        return fpCost;
    }

    public int getHpCost() {
        return hpCost;
    }

    public String getEffect() {
        return effect;
    }

    public String getDlc() {
        return dlc;
    }

    public String getImage() {
        return image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setDlc(String dlc) {
        this.dlc = dlc;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
