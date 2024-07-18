package com.codingmak.repositories;

import com.codingmak.model.Spiritsash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpiritsashRepository extends JpaRepository<Spiritsash, Long> {
    List<Spiritsash> findByNameContaining(String name);
}