package com.codingmak.service;

import com.codingmak.model.*;
import com.codingmak.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> search(Long id, String name, String type) {
        if (id != null) {
            return weaponRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return weaponRepository.findByNameContaining(name);
        }
        if (type != null) {
            return weaponRepository.findByTypeContaining(type);
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
        weapon.setSkill(entity.getSkill());
        weapon.setWeight(entity.getWeight());

        if (weapon.getAttack() == null) {
            weapon.setAttack(new Attack());
        }
        weapon.getAttack().setPhysical(entity.getAttack().getPhysical());
        weapon.getAttack().setMagical(entity.getAttack().getMagical());
        weapon.getAttack().setFire(entity.getAttack().getFire());
        weapon.getAttack().setLightning(entity.getAttack().getLightning());
        weapon.getAttack().setHoly(entity.getAttack().getHoly());
        weapon.getAttack().setCritical(entity.getAttack().getCritical());

        if (weapon.getGuard() == null) {
            weapon.setGuard(new Guard());
        }
        weapon.getGuard().setPhysical(entity.getGuard().getPhysical());
        weapon.getGuard().setMagical(entity.getGuard().getMagical());
        weapon.getGuard().setFire(entity.getGuard().getFire());
        weapon.getGuard().setLightning(entity.getGuard().getLightning());
        weapon.getGuard().setHoly(entity.getGuard().getHoly());
        weapon.getGuard().setBoost(entity.getGuard().getBoost());

        if (weapon.getRequire() == null) {
            weapon.setRequire(new Require());
        }
        weapon.getRequire().setStrength(entity.getRequire().getStrength());
        weapon.getRequire().setDexterity(entity.getRequire().getDexterity());
        weapon.getRequire().setIntelligence(entity.getRequire().getIntelligence());
        weapon.getRequire().setFaith(entity.getRequire().getFaith());
        weapon.getRequire().setArcane(entity.getRequire().getArcane());

        if (weapon.getScaling() == null) {
            weapon.setScaling(new Scaling());
        }
        weapon.getScaling().setStrength(entity.getScaling().getStrength());
        weapon.getScaling().setDexterity(entity.getScaling().getDexterity());
        weapon.getScaling().setIntelligence(entity.getScaling().getIntelligence());
        weapon.getScaling().setFaith(entity.getScaling().getFaith());
        weapon.getScaling().setArcane(entity.getScaling().getArcane());

        return save(weapon);
    }

    public void deleteById(Long id) {
        weaponRepository.deleteById(id);
    }
}
