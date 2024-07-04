package com.codingmak.service;

import com.codingmak.model.Ammunition;
import com.codingmak.repositories.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmmunitionService {

    @Autowired
    private AmmunitionRepository ammunitionRepository;

    public List<Ammunition> findAllAmmunition() {
        return ammunitionRepository.findAll();
    }

    public Ammunition saveAmmunition(Ammunition ammunition) {
        return ammunitionRepository.save(ammunition);
    }
}
