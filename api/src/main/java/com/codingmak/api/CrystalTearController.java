package com.codingmak.api;

import com.codingmak.model.CrystalTear;
import com.codingmak.service.CrystalTearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crystaltears")
public class CrystalTearController {

    @Autowired
    private CrystalTearService crystalTearService;

    @GetMapping
    public List<CrystalTear> getAllCrystalTears() {
        return crystalTearService.findAllCrystalTears();
    }

    @PostMapping
    public CrystalTear createItem(@RequestBody CrystalTear crystalTear) {
        return crystalTearService.saveItem(crystalTear);
    }

}
