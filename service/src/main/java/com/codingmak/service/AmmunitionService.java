package com.codingmak.service;

import com.codingmak.model.Ammunition;
import com.codingmak.repositories.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmmunitionService implements BaseService<Ammunition> {

    @Autowired
    private AmmunitionRepository ammunitionRepository;


    @Override
    public List<Ammunition> findAll() {
        return ammunitionRepository.findAll();
    }

    @Override
    public Optional<Ammunition> findById(Long id) {
        return ammunitionRepository.findById(id);
    }

    @Override
    public Ammunition save(Ammunition entity) {
        return ammunitionRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ammunitionRepository.deleteById(id);
    }
}
