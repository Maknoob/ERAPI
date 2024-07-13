package com.codingmak.repositories;

import com.codingmak.model.Ashes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AshesRepository extends JpaRepository<Ashes, Long> {
    List<Ashes> findByNameContaining(String name);
}