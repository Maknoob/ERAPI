package com.codingmak.service;

import com.codingmak.model.Shield;
import com.codingmak.repositories.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShieldService implements BaseService<Shield> {

    @Autowired
    private ShieldRepository shieldRepository;


    @Override
    public List<Shield> findAll() {
        return shieldRepository.findAll();
    }

    @Override
    public Optional<Shield> findById(Long id) {
        return shieldRepository.findById(id);
    }

    @Override
    public List<Shield> search(Long id, String name, String type) {
        return List.of();
    }


    /* @Override
    public Shield save(Shield entity) {
        return shieldRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        shieldRepository.deleteById(id);
    } */

}
