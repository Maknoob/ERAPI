package com.codingmak.service;

import com.codingmak.model.Ammunition;
import com.codingmak.repositories.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmmunitionService {

    @Autowired
    private AmmunitionRepository ammunitionRepository;


    public List<Ammunition> search(Long id, String name) {
        if (id != null) {
            return ammunitionRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return ammunitionRepository.findByNameContaining(name);
        }
        return ammunitionRepository.findAll();
    }


    /* @Override
    public Ammunition save(Ammunition entity) {
        return ammunitionRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ammunitionRepository.deleteById(id);
    } */
}
