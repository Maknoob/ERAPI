package com.codingmak.api;

import com.codingmak.model.Ashes;
import com.codingmak.service.AshesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ashes")
public class AshesController implements PpdInterface<Ashes> {

    @Autowired
    private AshesService ashesService;

    @GetMapping
    public List<Ashes> search(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name) {
        return ashesService.search(id, name);
    }


    @Override
    public Ashes create(Ashes entity) {
        return ashesService.save(entity);
    }

    @Override
    public Ashes update(Long id, Ashes entity) {
        return ashesService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        ashesService.deleteById(id);
    }
}