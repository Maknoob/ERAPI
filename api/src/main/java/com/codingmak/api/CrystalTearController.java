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
    public List<CrystalTear> search(Long id, String name, String type) {
        return List.of();
    }


    @Override
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
    }
}
