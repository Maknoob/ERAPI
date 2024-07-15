package com.codingmak.api;

import com.codingmak.model.Ammunition;
import com.codingmak.service.AmmunitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ammunition")
public class AmmunitionController implements PpdInterface<Ammunition> {

    @Autowired
    private AmmunitionService ammunitionService;

    @GetMapping
    public List<Ammunition> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name) {
        return ammunitionService.search(id, name);
    }

    @Override
    public Ammunition create(Ammunition entity) {
        return ammunitionService.create(entity);
    }

    @Override
    public Ammunition update(Long id, Ammunition entity) {
        return ammunitionService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        ammunitionService.deleteById(id);
    }
}
