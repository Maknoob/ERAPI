package com.codingmak.repositories;

import com.codingmak.model.Shield;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShieldRepository extends JpaRepository<Shield, Long> {
    List<Shield> findByNameContaining(String name);
    List<Shield> findByTypeContaining(String type);
}
