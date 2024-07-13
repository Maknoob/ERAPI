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
    public List<CrystalTear> search(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return crystalTearService.search(id, name, type);
    }


    /* @Override
    public CrystalTear update(Long id, CrystalTear entity) {
        CrystalTear crystalTear = crystalTearService.findById(id)
                .orElseThrow(() -> new RuntimeException("Crystal Tear not found."));
        crystalTear.setName(entity.getName());
        crystalTear.setType(entity.getType());
        crystalTear.setDlc(entity.getDlc());
        crystalTear.setImage(entity.getImage());
        crystalTear.setLocation(entity.getLocation());
        crystalTear.setDurationInSec(entity.getDurationInSec());
        crystalTear.setWhenUsed(entity.getWhenUsed());
        return crystalTearService.save(crystalTear);
    }

    @Override
    public CrystalTear create(CrystalTear entity) {
        return crystalTearService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crystalTearService.deleteById(id);
    } */
}
