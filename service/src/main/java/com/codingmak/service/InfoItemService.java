package com.codingmak.service;

import com.codingmak.model.InfoItem;
import com.codingmak.repositories.InfoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoItemService implements BaseService<InfoItem> {

    @Autowired
    private InfoItemRepository infoItemRepository;

    @Override
    public List<InfoItem> findAll() {
        return infoItemRepository.findAll();
    }

    @Override
    public Optional<InfoItem> findById(Long id) {
        return infoItemRepository.findById(id);
    }

    @Override
    public InfoItem save(InfoItem entity) {
        return infoItemRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        infoItemRepository.deleteById(id);
    }
}
