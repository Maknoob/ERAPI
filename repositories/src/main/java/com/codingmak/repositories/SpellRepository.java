package com.codingmak.repositories;

import com.codingmak.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpellRepository extends JpaRepository<Spell, Long> {
    List<Spell> findByType(String type);
    List<Spell> findByNameAndType(String name, String bonus);

    List<Spell> findByNameContaining(String name);

    List<Spell> findByBonusContaining(String bonus);
}
