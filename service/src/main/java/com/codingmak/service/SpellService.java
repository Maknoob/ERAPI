package com.codingmak.service;

import com.codingmak.model.Spell;
import com.codingmak.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpellService implements BaseService<Spell> {

    @Autowired
    private SpellRepository spellRepository;

    @Autowired
    private UserService userService;


    @Override
    public List<Spell> findAll() {
        return spellRepository.findAll();
    }

    @Override
    public Optional<Spell> findById(Long id) {
        return spellRepository.findById(id);
    }


    @Override
    public List<Spell> search(Long id, String name, String type) {
        if (id != null) {
            return spellRepository.findById(id).stream().toList();
        }
        if (name != null && type != null) {
            return spellRepository.findByNameAndType(name, type);
        }
        if ( name != null) {
            return spellRepository.findByName(name);
        }
        if (type != null) {
            return spellRepository.findByType(type);
        }

        return spellRepository.findAll();
    }

    public List<Spell> searchSorceries(Long id, String name, String type) {
        List<Spell> sorceries = spellRepository.findByType("Sorcery");

        if (id != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getId().equals(id)).collect(Collectors.toList());
        }
        if (name != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        if (type != null) {
            sorceries = sorceries.stream().filter(spell -> spell.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
        }

        return sorceries;
    }

    public List<Spell> searchIncantations(Long id, String name, String type) {
        List<Spell> incantations = spellRepository.findByType("Incantation");

        if (id != null) {
            incantations = incantations.stream().filter(spell -> spell.getId().equals(id)).collect(Collectors.toList());
        }
        if (name != null) {
            incantations = incantations.stream().filter(spell -> spell.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        if (type != null) {
            incantations = incantations.stream().filter(spell -> spell.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
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

    public List<Spell> findByName(String name) {
        return spellRepository.findByName(name);
    }
}
