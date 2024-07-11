package com.codingmak.api;

import com.codingmak.model.Spell;
import com.codingmak.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spells")
public class SpellController implements BaseController<Spell> {

    @Autowired
    private SpellService spellService;

    @Override
    public List<Spell> search(Long id, String name, String type) {
        return spellService.search(id, name, type);
    }

    @GetMapping("/sorceries")
    public List<Spell> getSorceries(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return spellService.searchSorceries(id, name, type);
    }

    @GetMapping("/incantations")
    public List<Spell> getIncantations(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return spellService.searchIncantations(id, name, type);
    }

    @Override
    public Spell update(Long id, Spell entity) {
        Spell spell = spellService.findById(id)
                .orElseThrow(() -> new RuntimeException("Spell not found"));
        spell.setName(entity.getName());
        spell.setType(entity.getType());
        spell.setDlc(entity.getDlc());
        spell.setImage(entity.getImage());
        spell.setBonus(entity.getBonus());
        spell.setEffect(entity.getEffect());
        spell.setFpCost(entity.getFpCost());
        spell.setSlot(entity.getSlot());
        spell.setLocation(entity.getLocation());
        spell.setRequiredStats(entity.getRequiredStats());
        spell.setStaminaCost(entity.getStaminaCost());
        return spellService.save(spell);
    }

    @Override
    public Spell create(Spell entity) {
        return spellService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        spellService.deleteById(id);
    }
}
