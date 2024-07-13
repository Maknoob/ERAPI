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

    public List<Weapon> search(Long id, String name, String type, String requires, String scaling) {
        if (id != null) {
            return weaponRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return weaponRepository.findByNameContaining(name);
        }
        if (type != null) {
            return weaponRepository.findByTypeContaining(type);
        }
        if (requires != null) {
            return weaponRepository.findByRequiresContaining(requires);
        }
        if (scaling != null) {
            return weaponRepository.findByScalingContaining(scaling);
        }
        return weaponRepository.findAll();
    }


    /* @Override
    public Weapon save(Weapon entity) {
        return weaponRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        weaponRepository.deleteById(id);
    } */
}
