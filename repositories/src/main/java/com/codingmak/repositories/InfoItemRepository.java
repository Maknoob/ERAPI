package com.codingmak.repositories;

import com.codingmak.model.InfoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoItemRepository extends JpaRepository<InfoItem, Long> {
    List<InfoItem> findByNameContaining(String name);
    List<InfoItem> findByTypeContaining(String type);
}
