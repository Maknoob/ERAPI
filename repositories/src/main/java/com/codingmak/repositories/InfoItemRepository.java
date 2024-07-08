package com.codingmak.repositories;

import com.codingmak.model.InfoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoItemRepository extends JpaRepository<InfoItem, Long> {
}
