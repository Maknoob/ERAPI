package com.codingmak.repositories;

import com.codingmak.model.AshOfWar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AshOfWarRepository extends JpaRepository<AshOfWar, Long> {
    List<AshOfWar> findByNameContaining(String name);
    List<AshOfWar> findBySkillContaining(String skill);
    List<AshOfWar> findByAffinityContaining(String affinity);


}
