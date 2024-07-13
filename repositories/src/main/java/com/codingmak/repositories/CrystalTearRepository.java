package com.codingmak.repositories;

import com.codingmak.model.CrystalTear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrystalTearRepository extends JpaRepository<CrystalTear, Long> {
    List<CrystalTear> findByNameContaining(String name);
    List<CrystalTear> findByTypeContaining(String type);
}
