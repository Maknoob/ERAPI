package com.codingmak.service;

import com.codingmak.model.*;
import com.codingmak.repositories.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShieldService {

    @Autowired
    private ShieldRepository shieldRepository;


    public List<Shield> search(Long id, String name, String type) {
        if (id != null) {
            return shieldRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return shieldRepository.findByNameContaining(name);
        }
        if (type != null) {
            return shieldRepository.findByTypeContaining(type);
        }
        return shieldRepository.findAll();
    }

    public Shield create(Shield entity) {
        if (entity.getId() != null) {
            Optional<Shield> existingShield = shieldRepository.findById(entity.getId());
            if (existingShield.isPresent()) {
                throw new RuntimeException("Shield with ID " + entity.getId() + " already exists.");
            }
        }
        return save(entity);
    }

    public Shield save(Shield entity) {
        return shieldRepository.save(entity);
    }

    public Shield update(Long id, Shield entity) {
        Shield shield = shieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shield not Found"));
        shield.setName(entity.getName());
        shield.setType(entity.getType());
        shield.setPassive(entity.getPassive());
        shield.setFpCost(entity.getFpCost());
        shield.setWeight(entity.getWeight());
        shield.setParrySkill(entity.getParrySkill());

        if (shield.getAttack() == null) {
            shield.setAttack(new Attack());
        }
        shield.getAttack().setPhysical(entity.getAttack().getPhysical());
        shield.getAttack().setMagical(entity.getAttack().getMagical());
        shield.getAttack().setFire(entity.getAttack().getFire());
        shield.getAttack().setLightning(entity.getAttack().getLightning());
        shield.getAttack().setHoly(entity.getAttack().getHoly());
        shield.getAttack().setCritical(entity.getAttack().getCritical());

        if (shield.getGuard() == null) {
            shield.setGuard(new Guard());
        }
        shield.getGuard().setPhysical(entity.getGuard().getPhysical());
        shield.getGuard().setMagical(entity.getGuard().getMagical());
        shield.getGuard().setFire(entity.getGuard().getFire());
        shield.getGuard().setLightning(entity.getGuard().getLightning());
        shield.getGuard().setHoly(entity.getGuard().getHoly());
        shield.getGuard().setBoost(entity.getGuard().getBoost());

        if (shield.getRequire() == null) {
            shield.setRequire(new Require());
        }
        shield.getRequire().setStrength(entity.getRequire().getStrength());
        shield.getRequire().setDexterity(entity.getRequire().getDexterity());
        shield.getRequire().setIntelligence(entity.getRequire().getIntelligence());
        shield.getRequire().setFaith(entity.getRequire().getFaith());
        shield.getRequire().setArcane(entity.getRequire().getArcane());

        if (shield.getScaling() == null) {
            shield.setScaling(new Scaling());
        }
        shield.getScaling().setStrength(entity.getScaling().getStrength());
        shield.getScaling().setDexterity(entity.getScaling().getDexterity());
        shield.getScaling().setIntelligence(entity.getScaling().getIntelligence());
        shield.getScaling().setFaith(entity.getScaling().getFaith());
        shield.getScaling().setArcane(entity.getScaling().getArcane());
        
        return save(shield);
    }

    public void deleteById(Long id) {
        shieldRepository.deleteById(id);
    }

}
