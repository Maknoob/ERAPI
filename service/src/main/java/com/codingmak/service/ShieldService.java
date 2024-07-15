package com.codingmak.service;

import com.codingmak.model.Shield;
import com.codingmak.repositories.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShieldService {

    @Autowired
    private ShieldRepository shieldRepository;


    public List<Shield> search(Long id, String name, String type, String requires, String scaling) {
        if (id != null) {
            return shieldRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return shieldRepository.findByNameContaining(name);
        }
        if (type != null) {
            return shieldRepository.findByTypeContaining(type);
        }
        if (requires != null) {
            return shieldRepository.findByRequiresContaining(requires);
        }
        if (scaling != null) {
            return shieldRepository.findByScalingContaining(scaling);
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
        shield.setRequires(entity.getRequires());
        shield.setScaling(entity.getScaling());
        shield.setPassive(entity.getPassive());
        shield.setFpCost(entity.getFpCost());
        shield.setWeight(entity.getWeight());
        shield.setParrySkill(entity.getParrySkill());
        shield.setAttackPhy(entity.getAttackPhy());
        shield.setAttackMag(entity.getAttackMag());
        shield.setAttackFire(entity.getAttackFire());
        shield.setAttackLigt(entity.getAttackLigt());
        shield.setAttackHoly(entity.getAttackHoly());
        shield.setAttackCrit(entity.getAttackCrit());
        shield.setGuardPhy(entity.getGuardPhy());
        shield.setGuardMag(entity.getGuardMag());
        shield.setGuardFire(entity.getGuardFire());
        shield.setGuardLigt(entity.getGuardLigt());
        shield.setGuardHoly(entity.getGuardHoly());
        shield.setGuardBoost(entity.getGuardBoost());
        return save(shield);
    }

    public void deleteById(Long id) {
        shieldRepository.deleteById(id);
    }

}
