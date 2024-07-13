package com.codingmak.repositories;

import com.codingmak.model.Ammunition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmmunitionRepository extends JpaRepository<Ammunition, Long> {
    List<Ammunition> findByNameContaining(String name);
}
