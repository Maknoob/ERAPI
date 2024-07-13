package com.codingmak.service;

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

    public List<Spell> findAll() {
        return spellRepository.findAll();
    }

    public Optional<Spell> findById(Long id) {
        return spellRepository.findById(id);
    }

    public List<Spell> search(Long id, String name, String type, String bonus) {
        if (id != null) {
            return spellRepository.findById(id).stream().toList();
        }
        if (name != null && type != null) {
            return spellRepository.findByNameAndType(name, type);
        }
        if (name != null) {
            return spellRepository.findByName(name);
        }
        if (type != null) {
            return spellRepository.findByType(type);
        }
        if (bonus != null) {
            return spellRepository.findByBonus(bonus);
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




    /* @Override
    public Spell save(Spell entity) {
            return spellRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        spellRepository.deleteById(id);
    } */
}
