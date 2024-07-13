package com.codingmak.api;

import com.codingmak.model.Weapon;
import com.codingmak.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weapons")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @GetMapping
    public List<Weapon> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "requires", required = false) String requires,
            @RequestParam(value = "scaling", required = false) String scaling) {
        return weaponService.search(id, name, type, requires, scaling);
    }


    /* @Override
    public Weapon update(Long id, Weapon entity) {
        Weapon weapon = weaponService.findById(id)
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
        return weaponService.save(weapon);
    }

    @Override
    public Weapon create(Weapon entity) {
        return weaponService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        weaponService.deleteById(id);
    } */
}
