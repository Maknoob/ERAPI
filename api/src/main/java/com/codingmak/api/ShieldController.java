package com.codingmak.api;


import com.codingmak.model.Shield;
import com.codingmak.service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shields")
public class ShieldController implements BaseController<Shield> {

    @Autowired
    private ShieldService shieldService;

    @Override
    public List<Shield> getAll() {
        return shieldService.findAll();
    }

    @Override
    public Optional<Shield> getById(Long id) {
        return shieldService.findById(id);
    }

    @Override
    public Shield update(Long id, Shield entity) {
        Shield shield = shieldService.findById(id)
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
        return shieldService.save(shield);
    }

    @Override
    public Shield create(Shield entity) {
        return shieldService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        shieldService.deleteById(id);
    }
}
