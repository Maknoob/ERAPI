package com.codingmak.repositories;

import com.codingmak.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    List<Weapon> findByNameContaining(String name);
    List<Weapon> findByTypeContaining(String type);
}
