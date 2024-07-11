package com.codingmak.service;

import com.codingmak.model.Ashes;
import com.codingmak.repositories.AshesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AshesService implements BaseService<Ashes> {

    @Autowired
    private AshesRepository ashesRepository;

    @Override
    public List<Ashes> findAll() {
        return ashesRepository.findAll();
    }

    @Override
    public Optional<Ashes> findById(Long id) {
        return ashesRepository.findById(id);
    }

    @Override
    public List<Ashes> search(Long id, String name, String type) {
        return List.of();
    }


    @Override
    public Ashes save(Ashes entity) {
        return ashesRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ashesRepository.deleteById(id);
    }
}
