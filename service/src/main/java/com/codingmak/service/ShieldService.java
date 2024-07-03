package com.codingmak.service;

import com.codingmak.model.Shield;
import com.codingmak.repositories.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShieldService {

    @Autowired
    private ShieldRepository shieldRepository;

    public List<Shield> findAllShields() {
        return shieldRepository.findAll();
    }

    public Shield saveShield(Shield shield) {
        return shieldRepository.save(shield);
    }

    public Optional<Shield> findById(Long id) {
        return shieldRepository.findById(id);
    }

}
