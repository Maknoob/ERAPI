package com.codingmak.service;

import com.codingmak.model.Ashes;
import com.codingmak.repositories.AshesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AshesService {

    @Autowired
    private AshesRepository ashesRepository;

    public List<Ashes> search(Long id, String name) {
        if (id != null) {
            return ashesRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return ashesRepository.findByNameContaining(name);
        }
        return ashesRepository.findAll();
    }


    /* @Override
    public Ashes save(Ashes entity) {
        return ashesRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ashesRepository.deleteById(id);
    } */
}
