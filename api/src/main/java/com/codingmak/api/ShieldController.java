package com.codingmak.api;


import com.codingmak.model.Shield;
import com.codingmak.service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shields")
public class ShieldController {

    @Autowired
    private ShieldService shieldService;

    @GetMapping
    public List<Shield> getAllShields() {
        return shieldService.findAllShields();
    }

    @PostMapping
    public Shield createShield(@RequestBody Shield shield) {
        return shieldService.saveShield(shield);
    }

    @PutMapping("/{id}")
    public Shield updateShield(@PathVariable("id") Long id, @RequestBody Shield shieldDetail) {
        Shield shield = shieldService.findById(id).orElseThrow(() -> new RuntimeException("Shield not Found"));
        shield.setName(shieldDetail.getName());
        shield.setType(shieldDetail.getType());
        shield.setRequires(shieldDetail.getRequires());
        shield.setScaling(shieldDetail.getScaling());
        shield.setPassive(shieldDetail.getPassive());
        shield.setFpCost(shieldDetail.getFpCost());
        shield.setWeight(shieldDetail.getWeight());
        shield.setParrySkill(shieldDetail.getParrySkill());
        shield.setAttackPhy(shieldDetail.getAttackPhy());
        shield.setAttackMag(shieldDetail.getAttackMag());
        shield.setAttackFire(shieldDetail.getAttackFire());
        shield.setAttackLigt(shieldDetail.getAttackLigt());
        shield.setAttackHoly(shieldDetail.getAttackHoly());
        shield.setAttackCrit(shieldDetail.getAttackCrit());
        shield.setGuardPhy(shieldDetail.getGuardPhy());
        shield.setGuardMag(shieldDetail.getGuardMag());
        shield.setGuardFire(shieldDetail.getGuardFire());
        shield.setGuardLigt(shieldDetail.getGuardLigt());
        shield.setGuardHoly(shieldDetail.getGuardHoly());
        shield.setGuardBoost(shieldDetail.getGuardBoost());
        return shieldService.saveShield(shield);
    }
}
