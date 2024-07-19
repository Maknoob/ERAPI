package com.codingmak.api;

import com.codingmak.model.Spell;
import com.codingmak.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/spells")
public class SpellController implements PpdInterface<Spell> {

    @Autowired
    private SpellService spellService;

    @GetMapping
    public Object search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "bonus", required = false) String bonus,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false) Integer size) {

        if (page == null || size == null) {
            int totalSize = (int) spellService.getCount();
            return new RedirectView(String.format("/spells?page=0&size=%d", totalSize));
        }

        Pageable pageable = PageRequest.of(page, size);
        return spellService.search(id, name, type, bonus, pageable);
    }

    @GetMapping("/sorceries")
    public Object getSorceries(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "bonus", required = false) String bonus,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            int totalSize = (int) spellService.getSorceryCount();
            return new RedirectView(String.format("/spells/sorceries?page=0&size=%d", totalSize));
        }

        Pageable pageable = PageRequest.of(page, size);
        return spellService.searchSorceries(id, name, bonus, pageable);
    }

    @GetMapping("/incantations")
    public Object getIncantations(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "bonus", required = false) String bonus,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            int totalSize = (int) spellService.getIncantationCount();
            return new RedirectView(String.format("/spells/incantations?page=0&size=%d", totalSize));
        }

        Pageable pageable = PageRequest.of(page, size);
        return spellService.searchIncantations(id, name, bonus, pageable);
    }

    @Override
    public Spell create(Spell entity) {
        return spellService.create(entity);
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
