package com.codingmak.repositories;

import com.codingmak.model.Multiplayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplayerRepository extends JpaRepository<Multiplayer, Long> {
}