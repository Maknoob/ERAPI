package com.codingmak.api;

import com.codingmak.model.Ashes;
import com.codingmak.service.AshesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ashes")
public class AshesController {

    @Autowired
    private AshesService ashesService;

    @GetMapping
    public List<Ashes> search(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name) {
        return ashesService.search(id, name);
    }

    /* @Override
    public Ashes update(Long id, Ashes entity) {
        Ashes ashes = ashesService.findById(id)
                .orElseThrow(() -> new RuntimeException("Ashes not found"));
        ashes.setName(entity.getName());
        ashes.setType(entity.getType());
        ashes.setFpCost(entity.getFpCost());
        ashes.setHpCost(entity.getHpCost());
        ashes.setEffect(entity.getEffect());
        ashes.setDlc(entity.getDlc());
        ashes.setImage(entity.getImage());
        return ashesService.save(ashes);
    }

    @Override
    public Ashes create(Ashes entity) {
        return ashesService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ashesService.deleteById(id);
    } */
}