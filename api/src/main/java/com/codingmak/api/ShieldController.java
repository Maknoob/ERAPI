package com.codingmak.api;


import com.codingmak.model.Shield;
import com.codingmak.service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shields")
public class ShieldController implements PpdInterface<Shield> {

    @Autowired
    private ShieldService shieldService;

    @GetMapping
    public List<Shield> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "requires", required = false) String requires,
            @RequestParam(value = "scaling", required = false) String scaling) {
        return shieldService.search(id, name, type, requires, scaling);
    }


    @Override
    public Shield create(Shield entity) {
        return shieldService.save(entity);
    }

    @Override
    public Shield update(Long id, Shield entity) {
        return shieldService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        shieldService.deleteById(id);
    }
}
