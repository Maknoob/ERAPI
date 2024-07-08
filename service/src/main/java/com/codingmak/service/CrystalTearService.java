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

    public List<CrystalTear> findAllCrystalTears() {
        return crystalTearRepository.findAll();
    }

    public CrystalTear saveItem(CrystalTear crystalTear) {
        return crystalTearRepository.save(crystalTear);
    }
}
