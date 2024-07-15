package com.codingmak.repositories;

import com.codingmak.model.Talisman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalismanRepository extends JpaRepository<Talisman, Long> {
    List<Talisman> findByNameContaining(String name);
}
