package com.codingmak.service;

import com.codingmak.model.Require;
import com.codingmak.model.Spell;
import com.codingmak.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    @Autowired
    private PagedResourcesAssembler<Spell> pagedResourcesAssembler;

    public long getCount() {
        return spellRepository.count();
    }

    public long getSorceryCount() {
        return spellRepository.countByType("Sorcery");
    }

    public long getIncantationCount() {
        return spellRepository.countByType("Incantation");
    }

    public PagedModel<?> search(Long id, String name, String type, String bonus, Pageable pageable) {
        Page<Spell> spellPage;
        if (id != null) {
            Optional<Spell> spell = spellRepository.findById(id);
            spellPage = spell.map(aow -> new PageImpl<>(Collections.singletonList(aow), pageable, 1))
                    .orElse(new PageImpl<>(Collections.emptyList(), pageable, 0));
        } else if (name != null) {
            spellPage = spellRepository.findByNameContaining(name, pageable);
        } else if (type != null) {
            spellPage = spellRepository.findByType(type, pageable);
        } else if (bonus != null) {
            spellPage = spellRepository.findByBonusContaining(bonus, pageable);
        } else {
            spellPage = spellRepository.findAll(pageable);
        }
        return pagedResourcesAssembler.toModel(spellPage);
    }

    public PagedModel<?> searchSorceries(Long id, String name, String bonus, Pageable pageable) {
        Page<Spell> spellPage;
        if (id != null) {
            Optional<Spell> spell = spellRepository.findById(id);
            spellPage = spell.map(aow -> new PageImpl<>(Collections.singletonList(aow), pageable, 1))
                    .orElse(new PageImpl<>(Collections.emptyList(), pageable, 0));
        } else if (name != null) {
            spellPage = spellRepository.findByNameContainingAndType(name, "Sorcery", pageable);
        } else if (bonus != null) {
            spellPage = spellRepository.findByBonusContainingAndType(bonus, "Sorcery", pageable);
        } else {
            spellPage = spellRepository.findByType("Sorcery", pageable);
        }
        return pagedResourcesAssembler.toModel(spellPage);
    }

    public PagedModel<?> searchIncantations(Long id, String name, String bonus, Pageable pageable) {
        Page<Spell> spellPage;
        if (id != null) {
            Optional<Spell> spell = spellRepository.findById(id);
            spellPage = spell.map(aow -> new PageImpl<>(Collections.singletonList(aow), pageable, 1))
                    .orElse(new PageImpl<>(Collections.emptyList(), pageable, 0));
        } else if (name != null) {
            spellPage = spellRepository.findByNameContainingAndType(name, "Incantation", pageable);
        } else if (bonus != null) {
            spellPage = spellRepository.findByBonusContainingAndType(bonus, "Incantation", pageable);
        } else {
            spellPage = spellRepository.findByType("Incantation", pageable);
        }
        return pagedResourcesAssembler.toModel(spellPage);
    }

    public Spell create(Spell entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public Spell save(Spell entity) {
            return spellRepository.save(entity);
    }

    public Spell update(Long id, Spell entity) {
        Spell spell = spellRepository.findById(id)
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
        spell.setStaminaCost(entity.getStaminaCost());

        if (spell.getRequire() == null) {
            spell.setRequire(new Require());
        }
        spell.getRequire().setStrength(entity.getRequire().getStrength());
        spell.getRequire().setDexterity(entity.getRequire().getDexterity());
        spell.getRequire().setIntelligence(entity.getRequire().getIntelligence());
        spell.getRequire().setFaith(entity.getRequire().getFaith());
        spell.getRequire().setArcane(entity.getRequire().getArcane());

        return save(spell);
    }

    public void deleteById(Long id) {
        spellRepository.deleteById(id);
    }
}
