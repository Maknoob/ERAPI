package com.codingmak.api;

import com.codingmak.model.Ashes;
import com.codingmak.service.AshesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ashes")
public class AshesController {

    @Autowired
    private AshesService ashesService;

    @GetMapping
    public List<Ashes> getAllAshes() {
        return ashesService.findAllAshes();
    }

    @GetMapping("/{id}")
    public Optional<Ashes> findById(@PathVariable("id") Long id) {
        return ashesService.findById(id);
    }

    @PostMapping
    public Ashes createAshes(@RequestBody Ashes ashes) {
        return ashesService.saveAshes(ashes);
    }

    @PutMapping("/{id}")
    public Ashes updateAshes(@PathVariable("id") Long id, @RequestBody Ashes ashesDetails) {
        Ashes ashes = ashesService.findById(id).orElseThrow(() -> new RuntimeException("Ashes not found"));
        ashes.setName(ashesDetails.getName());
        ashes.setType(ashesDetails.getType());
        ashes.setFpCost(ashesDetails.getFpCost());
        ashes.setHpCost(ashesDetails.getHpCost());
        ashes.setEffect(ashesDetails.getEffect());
        ashes.setDlc(ashesDetails.getDlc());
        ashes.setImage(ashesDetails.getImage());
        return ashesService.saveAshes(ashes);
    }

}