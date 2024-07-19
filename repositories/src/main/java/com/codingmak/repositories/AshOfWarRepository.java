package com.codingmak.repositories;

import com.codingmak.model.AshOfWar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AshOfWarRepository extends JpaRepository<AshOfWar, Long> {
    List<AshOfWar> findByNameContaining(String name);

    Page<AshOfWar> findByNameContaining(String name, Pageable pageable);
    Page<AshOfWar> findBySkillContaining(String skill, Pageable pageable);
    Page<AshOfWar> findByAffinityContaining(String affinity, Pageable pageable);


}
