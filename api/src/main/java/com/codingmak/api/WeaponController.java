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
    public List<Weapon> getAllWeapons() {
        return weaponService.findAllWeapons();
    }

    @PostMapping
    public Weapon createWeapon(@RequestBody Weapon weapon) {
        return weaponService.saveWeapon(weapon);
    }

}
