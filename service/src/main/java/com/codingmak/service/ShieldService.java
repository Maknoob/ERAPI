package com.codingmak.service;

import com.codingmak.model.Shield;
import com.codingmak.repositories.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShieldService {

    @Autowired
    private ShieldRepository shieldRepository;


    public List<Shield> search(Long id, String name, String type, String requires, String scaling) {
        if (id != null) {
            return shieldRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return shieldRepository.findByNameContaining(name);
        }
        if (type != null) {
            return shieldRepository.findByTypeContaining(type);
        }
        if (requires != null) {
            return shieldRepository.findByRequiresContaining(requires);
        }
        if (scaling != null) {
            return shieldRepository.findByScalingContaining(scaling);
        }
        return shieldRepository.findAll();
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
