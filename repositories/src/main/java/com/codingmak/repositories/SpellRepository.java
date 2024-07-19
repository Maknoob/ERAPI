package com.codingmak.repositories;

import com.codingmak.model.Spell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpellRepository extends JpaRepository<Spell, Long> {
    Page<Spell> findByType(String type, Pageable pageable);
    Page<Spell> findByNameContaining(String name, Pageable pageable);
    Page<Spell> findByBonusContaining(String bonus, Pageable pageable);

    Page<Spell> findByNameContainingAndType(String name, String type, Pageable pageable);
    Page<Spell> findByBonusContainingAndType(String bonus, String type, Pageable pageable);

    long countByType(String type);
}
