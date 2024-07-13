package com.codingmak.repositories;

import com.codingmak.model.Multiplayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiplayerRepository extends JpaRepository<Multiplayer, Long> {
    List<Multiplayer> findByNameContaining(String name);
    List<Multiplayer> findByTypeContaining(String type);
}
