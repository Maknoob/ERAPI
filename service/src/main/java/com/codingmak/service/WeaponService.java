package com.codingmak.service;

import com.codingmak.model.Weapon;
import com.codingmak.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> findAllWeapons() {
        return weaponRepository.findAll();
    }

    public Weapon saveWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

}
