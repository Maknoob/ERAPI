package com.codingmak.service;

import com.codingmak.model.Weapon;
import com.codingmak.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService implements BaseService<Weapon> {

    @Autowired
    private WeaponRepository weaponRepository;

    @Override
    public List<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    @Override
    public Optional<Weapon> findById(Long id) {
        return weaponRepository.findById(id);
    }

    @Override
    public Weapon save(Weapon entity) {
        return weaponRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        weaponRepository.deleteById(id);
    }
}
