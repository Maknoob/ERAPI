package com.codingmak.service;

import com.codingmak.model.CrystalTear;
import com.codingmak.repositories.CrystalTearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrystalTearService {

    @Autowired
    private CrystalTearRepository crystalTearRepository;


    public List<CrystalTear> search(Long id, String name, String type) {
        if (id != null) {
            return crystalTearRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return crystalTearRepository.findByNameContaining(name);
        }
        if (type != null) {
            return crystalTearRepository.findByTypeContaining(type);
        }
        return crystalTearRepository.findAll();
    }


    /* @Override
    public CrystalTear save(CrystalTear entity) {
        return crystalTearRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crystalTearRepository.deleteById(id);
    } */
}
