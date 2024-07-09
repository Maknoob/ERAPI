package com.codingmak.api;

import com.codingmak.model.CrystalTear;
import com.codingmak.service.CrystalTearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crystaltears")
public class CrystalTearController implements BaseController<CrystalTear> {

    @Autowired
    private CrystalTearService crystalTearService;

    @Override
    public List<CrystalTear> getAll() {
        return crystalTearService.findAll();
    }

    @Override
    public Optional<CrystalTear> getById(Long id) {
        return Optional.ofNullable(crystalTearService.findById(id)
                .orElseThrow(() -> new RuntimeException("Crystal Tear not found.")));
    }

    @Override
    public CrystalTear update(Long id, CrystalTear entity) {
        CrystalTear crystalTear = crystalTearService.findById(id)
                .orElseThrow(() -> new RuntimeException("Crystal Tear not found."));
        crystalTear.setName(crystalTear.getName());
        crystalTear.setType(crystalTear.getType());
        crystalTear.setDlc(crystalTear.getDlc());
        crystalTear.setImage(crystalTear.getImage());
        crystalTear.setLocation(crystalTear.getLocation());
        crystalTear.setDurationInSec(crystalTear.getDurationInSec());
        crystalTear.setWhenUsed(crystalTear.getWhenUsed());
        return crystalTearService.save(crystalTear);
    }

    @Override
    public CrystalTear create(CrystalTear entity) {
        return crystalTearService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crystalTearService.deleteById(id);
    }
}
