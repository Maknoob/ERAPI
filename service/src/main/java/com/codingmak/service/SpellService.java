package com.codingmak.service;

import com.codingmak.model.Require;
import com.codingmak.model.Spell;
import com.codingmak.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    public List<Spell> search(Long id, String name, String type, String bonus) {
        if (id != null) {
            return spellRepository.findById(id).stream().toList();
        }
        if (name != null && type != null) {
            return spellRepository.findByNameAndType(name, type);
        }
        if (name != null) {
            return spellRepository.findByNameContaining(name);
        }
        if (type != null) {
            return spellRepository.findByType(type);
        }
        if (bonus != null) {
            return spellRepository.findByBonusContaining(bonus);
        }

        return spellRepository.findAll();
    }

    public List<Spell> searchSorceries(Long id, String name, String bonus) {
        List<Spell> sorceries = spellRepository.findByType("Sorcery");

        if (id != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getId().equals(id)).collect(Collectors.toList());
        }
        if (name != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        if (bonus != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getBonus().equalsIgnoreCase(bonus)).collect(Collectors.toList());
        }

        return sorceries;
    }

    public List<Spell> searchIncantations(Long id, String name, String bonus) {
        List<Spell> incantations = spellRepository.findByType("Incantation");

        if (id != null) {
            incantations = incantations.stream().filter(spell -> spell.getId().equals(id)).collect(Collectors.toList());
        }
        if (name != null) {
            incantations = incantations.stream().filter(spell -> spell.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        if (bonus != null) {
            incantations = incantations.stream().filter(spell -> spell.getBonus().equalsIgnoreCase(bonus)).collect(Collectors.toList());
        }

        return incantations;
    }

    public Spell create(Spell entity) {
        if (entity.getId() != null) {
            Optional<Spell> existingSpell = spellRepository.findById(entity.getId());
            if (existingSpell.isPresent()) {
                throw new RuntimeException("Spell with ID " + entity.getId() + " already exists.");
            }
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
