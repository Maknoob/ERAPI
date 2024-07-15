package com.codingmak.api;

import com.codingmak.model.CrystalTear;
import com.codingmak.service.CrystalTearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crystaltears")
public class CrystalTearController implements PpdInterface<CrystalTear> {

    @Autowired
    private CrystalTearService crystalTearService;

    @GetMapping
    public List<CrystalTear> search(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return crystalTearService.search(id, name, type);
    }


    @Override
    public CrystalTear create(CrystalTear entity) {
        return crystalTearService.save(entity);
    }

    @Override
    public CrystalTear update(Long id, CrystalTear entity) {
        return crystalTearService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        crystalTearService.deleteById(id);
    }
}
