package com.codingmak.repositories;

import com.codingmak.model.Ammunition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmmunitionRepository extends JpaRepository<Ammunition, Long> {
}
