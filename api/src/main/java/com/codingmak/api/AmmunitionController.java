package com.codingmak.api;

import com.codingmak.model.Ammunition;
import com.codingmak.service.AmmunitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ammunition")
public class AmmunitionController {

    @Autowired
    private AmmunitionService ammunitionService;

    @GetMapping
    public List<Ammunition> getAllAmmunition() {
        return ammunitionService.findAllAmmunition();
    }

    @PostMapping
    public Ammunition createAmmunition(@RequestBody Ammunition ammunition) {
        return ammunitionService.saveAmmunition(ammunition);
    }
}
