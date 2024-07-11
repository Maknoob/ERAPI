package com.codingmak.service;

import com.codingmak.model.CrystalTear;
import com.codingmak.repositories.CrystalTearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrystalTearService implements BaseService<CrystalTear> {

    @Autowired
    private CrystalTearRepository crystalTearRepository;

    @Override
    public List<CrystalTear> findAll() {
        return crystalTearRepository.findAll();
    }

    @Override
    public Optional<CrystalTear> findById(Long id) {
        return crystalTearRepository.findById(id);
    }

    @Override
    public List<CrystalTear> search(Long id, String name, String type) {
        return List.of();
    }


    @Override
    public CrystalTear save(CrystalTear entity) {
        return crystalTearRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crystalTearRepository.deleteById(id);
    }
}
