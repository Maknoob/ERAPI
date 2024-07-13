package com.codingmak.service;

import com.codingmak.model.InfoItem;
import com.codingmak.repositories.InfoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoItemService {

    @Autowired
    private InfoItemRepository infoItemRepository;


    public List<InfoItem> search(Long id, String name, String type) {
        if (id != null) {
            return infoItemRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return infoItemRepository.findByNameContaining(name);
        }
        if (type != null) {
            return infoItemRepository.findByTypeContaining(type);
        }
        return infoItemRepository.findAll();
    }


    /* @Override
    public InfoItem save(InfoItem entity) {
        return infoItemRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        infoItemRepository.deleteById(id);
    } */
}
