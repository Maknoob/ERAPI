package com.codingmak.api;

import com.codingmak.model.Spell;
import com.codingmak.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spells")
public class SpellController implements PpdInterface<Spell> {

    @Autowired
    private SpellService spellService;

    @GetMapping
    public List<Spell> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "bonus", required = false) String bonus) {
        return spellService.search(id, name, type, bonus);
    }

    @GetMapping("/sorceries")
    public List<Spell> getSorceries(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "bonus", required = false) String bonus) {
        return spellService.searchSorceries(id, name, bonus);
    }

    @GetMapping("/incantations")
    public List<Spell> getIncantations(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "bonus", required = false) String bonus) {
        return spellService.searchIncantations(id, name, bonus);
    }

    @Override
    public Spell create(Spell entity) {
        return spellService.save(entity);
    }

    @Override
    public Spell update(Long id, Spell entity) {
        return spellService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        spellService.deleteById(id);
    }
}
