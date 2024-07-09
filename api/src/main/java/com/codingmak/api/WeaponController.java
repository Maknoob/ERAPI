package com.codingmak.api;

import com.codingmak.model.Weapon;
import com.codingmak.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("weapons")
public class WeaponController implements BaseController<Weapon> {

    @Autowired
    private WeaponService weaponService;


    @Override
    public List<Weapon> getAll() {
        return weaponService.findAll();
    }

    @Override
    public Optional<Weapon> getById(Long id) {
        return weaponService.findById(id);
    }

    @Override
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
    }
}
