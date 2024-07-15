package com.codingmak.api;

import com.codingmak.model.Weapon;
import com.codingmak.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weapons")
public class WeaponController implements PpdInterface<Weapon> {

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


    @Override
    public Weapon create(Weapon entity) {
        return weaponService.create(entity);
    }

    @Override
    public Weapon update(Long id, Weapon entity) {
        return weaponService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        weaponService.deleteById(id);
    }
}
