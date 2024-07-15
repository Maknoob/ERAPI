package com.codingmak.service;

import com.codingmak.model.Weapon;
import com.codingmak.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Weapon create(Weapon entity) {
        if (entity.getId() != null) {
            Optional<Weapon> existingWeapon = weaponRepository.findById(entity.getId());
            if (existingWeapon.isPresent()) {
                throw new RuntimeException("Weapon with ID " + entity.getId() + " already exists.");
            }
        }
        return save(entity);
    }

    public Weapon save(Weapon entity) {
        return weaponRepository.save(entity);
    }

    public Weapon update(Long id, Weapon entity) {
        Weapon weapon = weaponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weapon not Found"));
        weapon.setName(entity.getName());
        weapon.setType(entity.getType());
        weapon.setDlc(entity.getDlc());
        weapon.setImage(entity.getImage());
        weapon.setRequires(entity.getRequires());
        weapon.setScaling(entity.getScaling());
        weapon.setSkill(entity.getSkill());
        weapon.setWeight(entity.getWeight());
        weapon.setAttackPhy(entity.getAttackPhy());
        weapon.setAttackMag(entity.getAttackMag());
        weapon.setAttackFire(entity.getAttackFire());
        weapon.setAttackLigt(entity.getAttackLigt());
        weapon.setAttackHoly(entity.getAttackHoly());
        weapon.setAttackCrit(entity.getAttackCrit());
        weapon.setGuardPhy(entity.getGuardPhy());
        weapon.setGuardMag(entity.getGuardMag());
        weapon.setGuardFire(entity.getGuardFire());
        weapon.setGuardLigt(entity.getGuardLigt());
        weapon.setGuardHoly(entity.getGuardHoly());
        weapon.setGuardBoost(entity.getGuardBoost());
        return save(weapon);
    }

    public void deleteById(Long id) {
        weaponRepository.deleteById(id);
    }
}
